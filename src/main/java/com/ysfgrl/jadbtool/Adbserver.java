/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ysfgrl.jadbtool;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author yusuf
 */
public class Adbserver extends Thread implements Adb_callback {

    MainClass parent;
    List<Adbdevice> devices = new ArrayList<>();
    String deviceid_version = "";
    int selectdevice = -1;

    public Adbserver(MainClass parent) {
        this.parent = parent;
    }

    public void selectDevice(int index) {
        if (index >= 0 && index < devices.size()) {
            this.selectdevice = index;
            deviceid_version = "";
            parent.centerpanel.jLabel1.setText(devices.get(selectdevice).getSerial());
        } else {
            this.selectdevice = -1;
            parent.centerpanel.jLabel1.setText(".");
        }
    }

    public void reboot() {
        if (selectdevice >= 0 && selectdevice < devices.size()) {

            String command = parent.settings.getAdbPath() + " -s " + devices.get(selectdevice).getSerial() + " reboot";
            new command_exec(this, command, command_exec.ADB_REBOOT);
        } else {
            center_panel.addOutput("Select Device...:");
        }
    }
    
    public void opensettings() {
        if (selectdevice >= 0 && selectdevice < devices.size()) {

            String command = parent.settings.getAdbPath() + " -s " + devices.get(selectdevice).getSerial() + " shell am start -a android.settings.SETTINGS";
            new command_exec(this, command, command_exec.ADB_UNDEFINED);
        } else {
            center_panel.addOutput("Select Device...:");
        }
    }
    
    public void openwifisettings() {
        if (selectdevice >= 0 && selectdevice < devices.size()) {

            String command = parent.settings.getAdbPath() + " -s " + devices.get(selectdevice).getSerial() + " shell am start -a android.settings.WIFI_SETTINGS";
            new command_exec(this, command, command_exec.ADB_UNDEFINED);
        } else {
            center_panel.addOutput("Select Device...:");
        }
    }
    
    public void openethernetsettings() {
        if (selectdevice >= 0 && selectdevice < devices.size()) {

            String command = parent.settings.getAdbPath() + " -s " + devices.get(selectdevice).getSerial() + " shell am start -a android.settings.WIRELESS_SETTINGS";
            new command_exec(this, command, command_exec.ADB_UNDEFINED);
        } else {
            center_panel.addOutput("Select Device...:");
        }
    }
    
    public void openbrowser() {
        if (selectdevice >= 0 && selectdevice < devices.size()) {

            String command = parent.settings.getAdbPath() + " -s " + devices.get(selectdevice).getSerial() + " shell monkey -p com.android.browser -v 1";
            new command_exec(this, command, command_exec.ADB_UNDEFINED);
        } else {
            center_panel.addOutput("Select Device...:");
        }
    }
    
    public void openmediaplayer() {
        if (selectdevice >= 0 && selectdevice < devices.size()) {

            String command = parent.settings.getAdbPath() + " -s " + devices.get(selectdevice).getSerial() + " shell monkey -p android.rk.RockVideoPlayer -v 1";
            new command_exec(this, command, command_exec.ADB_UNDEFINED);
        } else {
            center_panel.addOutput("Select Device...:");
        }
    }

    public void openfiles() {
        if (selectdevice >= 0 && selectdevice < devices.size()) {

            String command = parent.settings.getAdbPath() + " -s " + devices.get(selectdevice).getSerial() + " shell monkey -p com.android.rk -v 1";
            new command_exec(this, command, command_exec.ADB_UNDEFINED);
        } else {
            center_panel.addOutput("Select Device...:");
        }
    }
    
    
    public void openabout() {
        if (selectdevice >= 0 && selectdevice < devices.size()) {

            String command = parent.settings.getAdbPath() + " -s " + devices.get(selectdevice).getSerial() + " shell am start -a android.settings.DEVICE_INFO_SETTINGS";
            new command_exec(this, command, command_exec.ADB_UNDEFINED);
        } else {
            center_panel.addOutput("Select Device...:");
        }
    }
    public void getPackageList() {
        if (selectdevice >= 0 && selectdevice < devices.size()) {

            String command = parent.settings.getAdbPath() + " -s " + devices.get(selectdevice).getSerial() + " shell pm list packages -3";
            new command_exec(this, command, command_exec.ADB_PACKAGELIST);
        } else {
            center_panel.addOutput("Select Device...:");
        }
    }

    public void install(String[] list) {
        if (selectdevice >= 0 && selectdevice < devices.size()) {

            try {
                for (int i = 0; i < list.length; i++) {
                    list[i] = parent.settings.getAdbPath() + " -s " + devices.get(selectdevice).getSerial() + " install " + list[i];
                }
                new command_exec(this, list, command_exec.ADB_INSTALL);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            center_panel.addOutput("Select Device...:");
        }
    }

     public void runcommand(String temp) {
        if (selectdevice >= 0 && selectdevice < devices.size()) {

            try {
                String command = parent.settings.getAdbPath() + " -s " + devices.get(selectdevice).getSerial() + " "+temp;
                new command_exec(this, command, command_exec.ADB_UNDEFINED);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            center_panel.addOutput("Select Device...:");
        }
    }
    
    public void uninstall(String packagename) {
        if (selectdevice >= 0 && selectdevice < devices.size()) {

            try {
                String command = parent.settings.getAdbPath() + " -s " + devices.get(selectdevice).getSerial() + " uninstall " + packagename;
                new command_exec(this, command, command_exec.ADB_UNINSTALL);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            center_panel.addOutput("Select Device...:");
        }
    }

    public void start(String name) {
        if (selectdevice >= 0 && selectdevice < devices.size()) {
            try {
                String command = parent.settings.getAdbPath() + " -s " + devices.get(selectdevice).getSerial() + " shell monkey -p " + name + " -v 1 ";
                new command_exec(this, command, command_exec.ADB_LAUNCH);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            center_panel.addOutput("Select Device...:");
        }
    }

    public void adbStart() {
        center_panel.addOutput("Adb Starting...:" + parent.settings.getAdbPath());
        new command_exec(this, parent.settings.getAdbPath() + " start-server", command_exec.ADB_START);
    }

    public void adbStop() {
        center_panel.addOutput("Adb Stoping...:" + parent.settings.getAdbPath());
        new command_exec(this, parent.settings.getAdbPath() + " kill-server", command_exec.ADB_STOP);
    }

    public void getDevices() {
        devices.clear();
        new command_exec(this, parent.settings.getAdbPath() + " devices", command_exec.ADB_LIST);
    }

    public void conneciptrange(String front, int start, int end) {

        for (int i = start; i < end; i++) {
            String tmp = front + "." + i;
            adbConnect(tmp);
        }
    }

    @Override
    public void start_command() {
        center_panel.addOutput("Start Command");
    }

    @Override
    public void end_command() {
        center_panel.addOutput("End Command");
    }

    public void adbConnect(String ip) {
        center_panel.addOutput("Connecting...:" + ip);
        new command_exec(this, parent.settings.getAdbPath() + " connect " + ip, command_exec.ADB_CONNECT);
    }

    public void adbDisconnect(String ip) {
        center_panel.addOutput("Disconnecting...:" + ip);
        new command_exec(this, parent.settings.getAdbPath() + " disconnect " + ip, command_exec.ADB_DISCONNECT);
    }

    @Override
    public void cennected() {
        getDevices();
    }

    @Override
    public void discennected() {
        getDevices();
    }

    @Override
    public void adbstart() {
        getDevices();
    }

    @Override
    public void adbstop() {

    }

    @Override
    public void devicelist(ArrayList<Adbdevice> device) {
        devices.clear();
        devices = device;

        parent.rightpanel.model.setRowCount(0);
        for (int i = 0; i < devices.size(); i++) {
            parent.rightpanel.model.addRow(new Object[]{devices.get(i)});
        }
    }

    @Override
    public void installed(String command, String lines) {

    }

    @Override
    public void uninstalled() {

    }

    @Override
    public void lanuch() {

    }

    @Override
    public void packagelist(ArrayList<String> list) {
        Commands_panel.jComboBox2.removeAllItems();
        for (int i = 0; i < list.size(); i++) {
            Commands_panel.jComboBox2.addItem(list.get(i));
        }

    }

}
