/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ysfgrl.jadbtool;

import java.util.ArrayList;

/**
 *
 * @author yusuf
 */
interface Adb_callback {
    
   public void start_command();
   public void end_command();
   public void cennected();
   public void discennected();
   public void adbstart();
   public void adbstop();
   public void devicelist(ArrayList<Adbdevice> device);
   public void installed(String command,String lines);
   public void uninstalled();
   public void lanuch();
   public void reboot();
   public void packagelist(ArrayList<String> list);
    
}
