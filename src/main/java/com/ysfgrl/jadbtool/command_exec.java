/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ysfgrl.jadbtool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author yusuf
 */
public class command_exec extends Thread {

    public final static int ADB_START = 1;
    public final static int ADB_STOP = 2;
    public final static int ADB_CONNECT = 3;
    public final static int ADB_DISCONNECT = 4;
    public final static int ADB_LIST = 5;
    public final static int ADB_INSTALL = 6;
    public final static int ADB_UNINSTALL = 7;
    public final static int ADB_LAUNCH = 8;
    public final static int ADB_REBOOT = 9;
    public final static int ADB_PUT = 10;
    public final static int ADB_GET = 11;
    public final static int ADB_PACKAGELIST = 12;
    public final static int ADB_UNDEFINED = 13;

    Adb_callback callback;
    String command;
    String[] command_list;
    int command_type;

    command_exec(Adb_callback callback, String command, int commandtype) {
        this.callback = callback;
        this.command = command;
        this.command_type = commandtype;
        this.start();

    }

    command_exec(Adb_callback callback, String[] command_list, int commandtype) {
        this.callback = callback;
        this.command_list = command_list;
        this.command_type = commandtype;
        this.start();

    }

    public void run() {
        callback.start_command();
        switch (command_type) {
            case command_exec.ADB_INSTALL:
                for (String command : command_list) {
                    exec(command);
                }
                break;
            default:
                exec(command);
                break;
        }
        callback.end_command();

    }

    private void exec(String commad) {
        try {
            //System.out.println("command:" + commad);
            center_panel.addOutput(commad);
            ArrayList<String> lines = new ArrayList<>();
            String line = null;
            Runtime rt = Runtime.getRuntime();
            Process proc = rt.exec(commad);
            BufferedReader br_input = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            while ((line = br_input.readLine()) != null) {
                center_panel.addOutput(line);
                lines.add(line);
            }
            this.callback(lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void callback(ArrayList<String> lines) {
        switch (command_type) {
            case command_exec.ADB_START:
                callback.adbstart();
                break;
            case command_exec.ADB_STOP:
                callback.adbstop();
                break;
            case command_exec.ADB_CONNECT:
                callback.cennected();
                break;
            case command_exec.ADB_DISCONNECT:
                callback.discennected();
            case command_exec.ADB_LIST:
                ArrayList<Adbdevice> device = new ArrayList<>();
                if (lines.size() > 1) {
                    for (int i = 1; i < lines.size(); i++) {
                        System.out.println("-----------");
                        System.out.println(lines.get(i));
                        if (lines.get(i).contains("device")) {
                            String temp = lines.get(i).replace("device", "");
                            temp = temp.trim();
                            device.add(new Adbdevice(temp));
                        }
                    }
                }

                callback.devicelist(device);
                break;
            case command_exec.ADB_INSTALL:
                String temp = "";
                for (String line : lines) {
                    temp += line;
                }
                callback.installed(command, temp);
                break;
            case command_exec.ADB_UNINSTALL:
                callback.uninstalled();
                break;
            case command_exec.ADB_LAUNCH:
                callback.lanuch();
                break;
            case command_exec.ADB_REBOOT:
                callback.reboot();
                break;
            case command_exec.ADB_PACKAGELIST:
                callback.packagelist(lines);
                break;
            case command_exec.ADB_PUT:

                break;
            case command_exec.ADB_GET:
                break;
            default:
                break;

        }
    }
}
