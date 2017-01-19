package ServiceImpl;

import Service.GetPath;
import com.sun.xml.internal.ws.util.StringUtils;


import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;


/**
 * Created by olence on 2017/1/15.
 */
public class GetPathImpl implements GetPath {

    @Override
    public void copyFileAndFloder(String[] paths, String realpath) {
        if (paths != null && paths.length > 0) {
            for (String path : paths) {
                //对path的处理
                path = path.replace(".java", ".class");
                //对realpath的处理

                creatFile(realpath, path);
            }
        }
    }

    //path 是文件的地址,realpath是文件绝对地址
    public void creatFile(String realpath, String path) {
        //桌面地址
        String desktop = FileSystemView.getFileSystemView().getHomeDirectory().getAbsolutePath();
        //创建空文件
        File file = new File(desktop + "/" + path);
        File sourceFile = new File(realpath);
        try {
            FileInputStream inputStream = new FileInputStream(sourceFile);
            FileOutputStream outputStream = new FileOutputStream(file);
            byte[] bytes = new byte[1024];
            while (inputStream.read(bytes) != -1) {
                outputStream.write(bytes);
            }
            inputStream.close();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
