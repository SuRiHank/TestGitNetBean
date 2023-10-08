
package DAO;

//import Model.Manga;
//import connectPostgre.DBContext;
import com.connect.DBContext;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Manga;


public class mangaDao implements mangaInterface {
    List<Manga> listOfMangas = new ArrayList<>();
    
    @Override
    public List<Manga> getAllMangas() {
        Connection cnt = null;
        PreparedStatement stm = null;
        ResultSet res = null;
        try{
            String sql = "select * from Manga";
            cnt = DBContext.getConnection();
            stm = cnt.prepareStatement(sql);    
            res = stm.executeQuery();
            while(res.next()){
                Integer id = res.getInt("mangaID");
                String title = res.getString("title");
                String description = res.getString("description");
                Integer userID = res.getInt("userID");
                Date createdAt = res.getDate("createdAt");
                Boolean isCopyright = res.getBoolean("isCopyright");
                Boolean isFree = res.getBoolean("isFree");
                Manga manga = new Manga(id, title, description, userID , createdAt, isCopyright,isFree);
                listOfMangas.add(manga);
            }
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }finally{
            try {
                cnt.close();
                stm.close();
                res.close();
            } catch (SQLException ex) {
                Logger.getLogger(mangaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listOfMangas;    
    }

    @Override
    public void addManga(int product_id, String product_type, String product_name,
            BigDecimal product_price, int product_numberof, int product_available, 
            String product_detail, String product_img, String product_brand, int product_review) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DBContext.getConnection();
            String sql = "INSERT INTO product (product_id, product_type, product_name, product_price,"
                    + "product_numberof, product_available, product_detail, product_img,"
                    + "product_brand, product_review) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ? ,?)";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, product_id);
            stmt.setString(2, product_type);
            stmt.setString(3, product_name);
            stmt.setBigDecimal(4, product_price);
            stmt.setInt(5, product_numberof);
            stmt.setInt(6, product_available);
            stmt.setString(7, product_detail);
            stmt.setString(8, product_img);
            stmt.setString(9, product_brand);
            stmt.setInt(10, product_review);
            stmt.executeUpdate();
            System.out.println("Inserted successfully!");

        } catch (SQLException e) {
            System.out.println("Error occurred while inserting: " + e.getMessage());
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("Error occurred while closing database resources: " + e.getMessage());
            }
        }
    }

    @Override
    public void updateManga(String type, String name, BigDecimal price, int numberof, 
        int available, String detail, String img, String brand, int review, int id) {
        Connection cnt = null;
        PreparedStatement stm = null;
        try {
            String sql = "UPDATE product SET product_type = ?, product_name = ?,"
                    + " product_price = ?, product_numberof = ?, product_available = ?, "
                    + " product_detail = ?, product_img = ?, product_brand = ?,"
                    + " product_review = ? WHERE product_id = ?";

            cnt = DBContext.getConnection();
            stm = cnt.prepareStatement(sql);
            stm.setString(1, type);
            stm.setString(2, name);
            stm.setBigDecimal(3, price);
            stm.setInt(4, numberof);
            stm.setInt(5, available);
            stm.setString(6, detail);
            stm.setString(7, img);
            stm.setString(8, brand);
            stm.setInt(9, review);
            
            
            stm.setInt(10, id);

            int rowsUpdated = stm.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Updated successfully.");
            } else {
                System.out.println("Not found with the provided ID.");
            }
        } catch (SQLException e) {
            System.out.println("Error occurred while updating: " + e.getMessage());
        } finally {
            try {
                if (stm != null) {
                    stm.close();
                }
                if (cnt != null) {
                    cnt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void deleteManga(Integer id) {
        Connection cnt = null;
        PreparedStatement stm = null;
        ResultSet res = null;
         try{
            String sql = "delete from product where product_id = ?";
            cnt = DBContext.getConnection();
            cnt.setAutoCommit(false);
            stm = cnt.prepareStatement(sql);
            stm.setInt(1,id);
            stm.executeUpdate();
            cnt.commit();
            System.err.println("Delete!");
        }catch(SQLException e){
            System.out.println(e.getMessage());
            try{
                cnt.rollback();
            }catch(SQLException e1){
                e1.printStackTrace();
            }
        }finally{
            try{
                if (cnt != null){
                   cnt.close();
               }
               if (stm != null){
                   stm.close();
               }
            }catch(Exception e2){
                e2.printStackTrace();
            }
        }
    }

    @Override
    public Manga findManga(Predicate<Manga> p) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        Manga product = null;

        try {
            conn = DBContext.getConnection();
            String sql = "SELECT * FROM Manga";
            stmt = conn.prepareStatement(sql);
            res = stmt.executeQuery();

            while (res.next()) {
                Integer id = res.getInt("product_id");
                String type = res.getString("product_type");
                String name = res.getString("product_name");
                BigDecimal price = res.getBigDecimal("product_price");
                Integer numberof = res.getInt("product_numberof");
                Integer available = res.getInt("product_available");
                String detail = res.getString("product_detail");
                String img = res.getString("product_img");
                String brand = res.getString("product_brand");
                Integer review = res.getInt("product_review");

//                Manga currentManga = new Manga(id, type, name, price, numberof, available, detail, img, brand, review);

//                if (p.test(currentManga)) {
//                    product = currentManga;
//                    break;
//                }
            }
        } catch (SQLException e) {
            System.out.println("Error occurred while searching for product: " + e.getMessage());
        } finally {
            try {
                if (res != null) {
                    res.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("Error occurred while closing database resources: " + e.getMessage());
            }
        }

        return product;
    }
    public int getTotalRows() throws Exception {
        int rows = 0;
        Connection conn = null;
        PreparedStatement ps = null; 
        ResultSet rs = null;

        String query = "select count(*) from product";

        try {
            conn = DBContext.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                rows = rs.getInt(1);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            DBContext.close(conn, ps, rs);
        }
        return rows;
    }
    public List<Manga> getMangaPaging(int index) throws
            Exception {
        
        List<Manga> products = new ArrayList<>();
        String query = "SELECT * FROM product \n" 
                + "ORDER BY product_id \n" 
                + "OFFSET ? ROWS FETCH NEXT 8 ROWS ONLY;";

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DBContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, (index - 1) * 8);
   
            rs = ps.executeQuery();
            while (rs.next()) {
                Integer id = rs.getInt("1");
                String title = rs.getString("2");
                String description = rs.getString("3");
                Integer userID = rs.getInt("4");
                Date creatAt = rs.getDate("5");
                Boolean isCopyright = rs.getBoolean("6");
                Boolean isFree = rs.getBoolean("7");
                Manga manga = new Manga(id, title, description, userID , creatAt, isCopyright,isFree);
                listOfMangas.add(manga);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            DBContext.close(conn, ps, rs);
        }
        return products;
    }
    
    public int getCountSearch(String txtSearch) throws Exception {
        
        Connection conn = null;
        PreparedStatement ps = null; 
        ResultSet rs = null;

        String query = "select count(*) from product where product_name like ?";

        try {
            conn = DBContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, "%" + txtSearch + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            DBContext.close(conn, ps, rs);
        }
        return 0;
    }
//                                                        , int index, int size
    public List<Manga> searchMangaByTitle(String txtSearch, int index, int size) throws
            Exception {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            List<Manga> list = new ArrayList<>();
            String query = "with x as(select ROW_NUMBER() over (order by mangaID asc) as r\n"
                    + ",* from Manga where title like ?)\n"
                    + "select * from x where r between (?-1)*8+1 and ?*8";
            conn = DBContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, "%" + txtSearch + "%");
            ps.setInt(2, index);
            ps.setInt(3, index);
//            String query = "select * from Manga where title like ?";
//            conn = DBContext.getConnection();
//            ps = conn.prepareStatement(query);
//            ps.setString(1, "%" + txtSearch + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                Integer id = rs.getInt(2);
                String title = rs.getString(3);
                String description = rs.getString(4);
                Integer userID = rs.getInt(5);
                Date createdAt = rs.getDate(6);
                Boolean isCopyright = rs.getBoolean(7);
                Boolean isFree = rs.getBoolean(8);
                listOfMangas.add(new Manga(id, title, description, userID, createdAt, isCopyright, isFree));
            }
            return list;
        } catch (Exception ex) {
            throw ex;
        } finally {
            DBContext.close(conn, ps, rs);
        }

    }
    public List<Manga> searchMangaByCategory(String cate) throws Exception {
        List<Manga> mg = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT Manga.*\n"
                + "FROM Manga\n"
                + "JOIN Category ON Manga.mangaID = Category.mangaID\n"
                + "WHERE Category.type = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, cate);
            rs = ps.executeQuery();
            while (rs.next()) {
                mg.add(new Manga(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDate(5), rs.getBoolean(6), rs.getBoolean(7)));
            }
        } catch (Exception e) {

        }
        return mg;
    }
}
