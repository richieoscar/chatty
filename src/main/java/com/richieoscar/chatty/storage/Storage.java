package com.richieoscar.chatty.storage;

import java.util.Set;

public interface Storage {

    void addUSer(String user) throws Exception;
    void deleteUser(String user);
}
