package ServiceImpl;

import Service.GetPath;
import com.sun.xml.internal.ws.util.StringUtils;


import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


/**
 * Created by olence on 2017/1/15.
 */
public class GetPathImpl implements GetPath {

    @Override
    public void copyFileAndFloder(String[] paths, String realpath) {
        String targetPath = "";
        String[] marks = {"cn", "conf", "static", "WEB-INF" };
        if(paths != null && paths.length > 0) {
            for(String path : paths) {
                //对path的处理
                path = path.replace(".java", ".class");
                for(String mark : marks) {
                    if(path.contains(mark)) {
                        path = path.substring(path.indexOf(mark) - 1);
                        if(path.contains(mark)) {
                            if(mark.equals("cn") || mark.equals("conf"))
                                targetPath = realpath + "/WEB-INF/classes" + path;
                            else
                                targetPath = realpath + path;
                            break;
                        }
                    }
                }
                String deskpath = targetPath.substring(targetPath.indexOf("target") + "target".length());

                //对realpath的处理
                creatFile(targetPath, deskpath);
            }
        }
    }

    //path 是文件的地址,realpath是文件绝对地址
    public void creatFile(String realpath, String path) {
        //桌面地址
        String desktop = FileSystemView.getFileSystemView().getHomeDirectory().getAbsolutePath();
        //创建空文件

        CreateOutFile(desktop + path);
        File file = new File(desktop + path);
        File sourceFile = new File(realpath);
        try {
            FileInputStream inputStream = new FileInputStream(sourceFile);
            FileOutputStream outputStream = new FileOutputStream(file);
            byte[] bytes = new byte[1024];
            while(inputStream.read(bytes) != -1) {
                outputStream.write(bytes);
            }
            inputStream.close();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void CreateOutFile(String destFileName) {
        File file = new File(destFileName);
        if(file.exists()) {
            System.out.println("创建单个文件" + destFileName + "失败，目标文件已存在！");
            return;
        }
        if(destFileName.endsWith(File.separator)) {
            System.out.println("创建单个文件" + destFileName + "失败，目标不能是目录！");
            return;
        }
        if(!file.getParentFile().exists()) {
            System.out.println("目标文件所在路径不存在，准备创建。。。");
            if(!file.getParentFile().mkdirs()) {
                System.out.println("创建目录文件所在的目录失败！");
                return;
            }
        }
        // 创建目标文件
        try {
            if(file.createNewFile()) {
                System.out.println("创建单个文件" + destFileName + "成功！");
                return;
            } else {
                System.out.println("创建单个文件" + destFileName + "失败！");
                return;
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("创建单个文件" + destFileName + "失败！");
            return;
        }
    }

}
