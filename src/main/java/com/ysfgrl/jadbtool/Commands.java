/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ysfgrl.jadbtool;

/**
 *
 * @author yusuf
 */
public class Commands {
    private String name;
    private String command;

    /**
     * @return the name
     */
    
    
    public Commands() {
    }

    public Commands(String name, String command) {
        this.name = name;
        this.command = command;
    }

    
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the command
     */
    public String getCommand() {
        return command;
    }

    /**
     * @param command the command to set
     */
    public void setCommand(String command) {
        this.command = command;
    }
}
