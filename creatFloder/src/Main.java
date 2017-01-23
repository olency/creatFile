import Service.GetPath;
import ServiceImpl.GetPathImpl;

import javax.swing.*;

public class Main extends JFrame {


    public static void main(String[] args) {
//        String targetUrl = "D:\\workspace\\bdcdj_cs\\server\\target\\estateplat-server-V1.1.0-SNAPSHOT-20170120100307";
//        String[] svnUrl = {"/estateplat/branches/server/cs/server/src/main/java/cn/gtmap/estateplat/server/core/mapper/DjsjFwMapper.java", "/estateplat/branches/server/cs/server/src/main/java/cn/gtmap/estateplat/server/core/service/impl/DjsjFwServiceImpl.java ", "/estateplat/branches/server/cs/server/src/main/resources/conf/mybatis/DjsjFw.xml" };
//        GetPath getPath = new GetPathImpl();
//        getPath.copyFileAndFloder(svnUrl, targetUrl);
        creatFrame();
    }

    public static void creatFrame() {
        JLabel targetLabel = new JLabel("本地target地址：");
        JLabel svnLable = new JLabel("svn地址：");
        JTextField url = new JTextField(12);
        JTextArea svnUrl = new JTextArea(20, 20);
        JButton sure = new JButton("拷贝文件到桌面");

    }


}
