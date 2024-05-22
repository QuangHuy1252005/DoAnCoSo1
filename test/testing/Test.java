
package testing;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import swing.burhash.BlurHash;

public class Test {
    public static void main(String[] args)  {
        try {
            BufferedImage image = ImageIO.read(new File("C:\\Users\\Admin\\Pictures\\doancoso1\\dog.jpg"));
      String blurhashStr = BlurHash.encode(image);
            System.out.println(blurhashStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
            
}
