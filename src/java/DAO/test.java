
package DAO;

import model.Manga;
import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
public class test {

    public static void main(String[] args) throws Exception {
        mangaDao manage = new mangaDao();

//        System.out.println(manage.getAllMangas()+"\n");

//
        System.out.println(manage.searchMangaByTitle("M",1,2));
        List<Manga> result = manage.searchMangaByTitle("M",1,2);
        System.out.println(result.size());
//              In câu truy vấn SQL để kiểm tra
//             mangaDao dao = new mangaDao();
//        String category = "Romance";
//        dao.searchMangaByCategory(category);
//        List<Manga> bk = dao.searchMangaByCategory(category);
//        for (Manga b: bk)
//        {
//            System.out.println(b);
//            
//        }



    }
    
}
