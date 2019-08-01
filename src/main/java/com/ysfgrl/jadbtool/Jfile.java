/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ysfgrl.jadbtool;

import java.io.File;
import java.util.ArrayList;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author yusuf
 */
public class Jfile {

    File file;
    ArrayList<File> filelist = new ArrayList<>();
    public Jfile(File file) {
        this.file = file;
    }

    public void readFiles() {
        if(file.isDirectory()){
            File[] files = file.listFiles();
            
            filelist.add(file);
            
            for (File filee : files) {
                filelist.add(filee);
            }
        }
    }

}
