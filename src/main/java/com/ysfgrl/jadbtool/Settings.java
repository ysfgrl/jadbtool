/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ysfgrl.jadbtool;

import java.io.File;
import java.util.ArrayList;
import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author yusuf
 */
public class Settings {

    JSONObject settings_json;
    private String settings_path = "./setting/setting.json";

    private String default_settings="{\"adb\":{\"path\":\"\"},\"commands\":[]}";
    public Settings() {
        this("./setting/setting.json");
    }

    public Settings(String path) {
        this.settings_path=path;
        initsettings();
        ReadSettings();
    }
    
    private void initsettings(){
        try {
            File folder=new File("./setting");
            if(!folder.exists()){
                System.out.println("Not found folder");
                folder.mkdirs();
                File file=new File(settings_path);
                if(!file.exists()){
                    System.out.println("Not found file");
                    file.createNewFile();
                    FileUtils.writeStringToFile(file, default_settings);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getAdbPath() {
        String temp = "";
        try {
            temp = settings_json.getJSONObject("adb").getString("path");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return temp;
    }

    public void setAdbPath(String path) {
        try {
            settings_json.getJSONObject("adb").put("path", path);
            WriteSettings();
            ReadSettings();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Commands> getCommands() {
        ArrayList<Commands> temp = new ArrayList<>();
        try {
            JSONArray arr = settings_json.getJSONArray("commands");
            for (int i = 0; i < arr.length(); i++) {
                JSONObject obje = arr.getJSONObject(i);
                temp.add(new Commands(obje.getString("name"), obje.getString("command")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return temp;
    }

    
    public void addCommand(String command){
        try {
            JSONObject temp=new JSONObject();
            temp.put("name", "name");
            temp.put("command", command);
            settings_json.getJSONArray("commands").put(temp);
            WriteSettings();
            ReadSettings();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void WriteSettings() {
        try {
            System.out.println(settings_json.toString());
            FileUtils.writeStringToFile(new File(this.settings_path), settings_json.toString());
        } catch (Exception e) {
        }
    }
    private void ReadSettings(){
        try {
            String s1 = FileUtils.readFileToString(new File(settings_path));
            settings_json = new JSONObject(s1);
            System.out.println(settings_json.toString());
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
