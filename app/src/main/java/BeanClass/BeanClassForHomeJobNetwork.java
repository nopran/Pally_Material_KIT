package BeanClass;

/**
 * Created by Wolf Soft on 9/26/2017.
 */

public class BeanClassForHomeJobNetwork {

    int image;
    String title;


    public BeanClassForHomeJobNetwork(int image, String title) {
        this.image = image;
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
