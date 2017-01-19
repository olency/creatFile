package Service;

/**
 * Created by olence on 2017/1/15.
 */
public interface GetPath {
    //path是svn中的地址,realpath是class的路径
    public void copyFileAndFloder(String[] paths, String realPath);
}
