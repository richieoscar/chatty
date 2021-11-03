
$(document).ready(function () {
    $(function () {
        $("form").on('submit', function (e) {
            e.preventDefault();
        });
        $( "#connect" ).click(function() { register(); });

    });
})
const url = "http://localhost:8080";
let stompClient;
let selectedUser;





function connect(username) {
    console.log("Handling chat");
    const socket = new SockJS(url + username);
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        console.log("Connected to " + frame);
        stompClient.subscribe("/topic/messages" + username, function (response) {
            let data = JSON.parse(response.body);
            console.log(data);
        });
    });
}
function sendMessage(fromUser, text) {
    stompClient.send("/app/chatty" +selectedUser, JSON.stringify(
        {
            content:text,
            userName: fromUser

        } ));

}

function register() {
    let username = document.getElementById("name").value;
    //connect(username);
    $.get(url+"/register/"+username, function (response) {
        connect(username);

    }).fail(function (error) {
        if(error.status ===400){
            alert("Login is busy");
        }
    });

}

function fethUsers() {
    $.get(url+"/fetchUsers", function (response) {
        let users = response;
        users.forEach(user=> {
            $("#userslist").text(user);
        })


    })

}




