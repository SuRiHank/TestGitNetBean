
package DAO;


import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;
import model.Manga;

/**
 *
 * @author Admin
 */
public interface mangaInterface {
    List<Manga> getAllMangas();
    void addManga(int mangaID, String title, String description, 
            int userID, Date createdAt,
            String product_detail, String product_img, String product_brand, int product_review);
    void updateManga(String type, String name, BigDecimal price, int numberof, 
        int available, String detail, String img, String brand, int review, int id);
    void deleteManga(Integer id);
    Manga findManga(Predicate<Manga> p);
}
