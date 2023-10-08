
package DAO;


import java.math.BigDecimal;
import java.util.List;
import java.util.function.Predicate;
import model.Manga;

/**
 *
 * @author Admin
 */
public interface mangaInterface {
    List<Manga> getAllMangas();
    void addManga(int product_id, String product_type, String product_name, 
            BigDecimal product_price, int product_numberof, int product_available,
            String product_detail, String product_img, String product_brand, int product_review);
    void updateManga(String type, String name, BigDecimal price, int numberof, 
        int available, String detail, String img, String brand, int review, int id);
    void deleteManga(Integer id);
    Manga findManga(Predicate<Manga> p);
}
