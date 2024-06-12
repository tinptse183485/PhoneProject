package product;

import utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import user.UserDTO;

public class ProductDAO {

    private static final String CHECK_DUPLICATE = "SELECT mobileId FROM tblMobile WHERE mobileId=?  ";
    private static final String INSERT = "INSERT INTO tbl_Mobile (mobileId, price,mobileName,mobileBrand,quantity,sale,description) "
            + "                         VALUES(?,?,?,?,?,?,?)";
    private static final String SEARCH_BY_ID_OR_NAME = "SELECT mobileId, description, price, mobileName, yearOfProduction, quantity, notSale FROM tbl_Mobile WHERE mobileId LIKE ? OR mobileName LIKE ?";
    private static final String SEARCH_BY_PRICE_RANGE = "SELECT mobileId, description, price, mobileName, mobileBrand, quantity,sale,image  FROM tblMobile WHERE price BETWEEN ? AND ?";
    private static final String UPDATE_QUANTITY = "UPDATE tbl_Mobile SET quantity=? WHERE mobileId=?";

    public List<ProductDTO> getListProductByPrice(double fromPrice, double toPrice) throws Exception {
        List<ProductDTO> list = new ArrayList<>();
        String sql = SEARCH_BY_PRICE_RANGE;

        try (Connection conn = DBUtils.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setDouble(1, fromPrice);
            ps.setDouble(2, toPrice);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    String mobileId = rs.getString("mobileId");
                    String mobileName = rs.getString("mobileName");
                    String image = rs.getString("image");
                    double price = rs.getDouble("price");
                    int quantity = rs.getInt("quantity");
                    int sale = rs.getInt("sale");
                    String mobileBrand = rs.getString("mobileBrand");
                    String description = rs.getString("description");
                    list.add(new ProductDTO(mobileId, description, price, mobileName, mobileBrand, quantity, sale,image));
                }

            }
        }
        return list;

    }

    public boolean removeProduct(String productId) throws Exception {
        boolean isRemoved = false;
        String sql = "DELETE FROM tblMobile WHERE mobileId=?";

        try (Connection conn = DBUtils.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, productId);
            int affectedRows = ps.executeUpdate();
            if (affectedRows > 0) {
                isRemoved = true;
            }
        }
        return isRemoved;
    }

    public boolean addProduct(ProductDTO product) throws Exception {
        boolean isAdded = false;
        String sql = "INSERT INTO tblMobile(mobileId, mobileName, price, quantity, description,mobileBrand,image) VALUES (?, ?, ?, ?, ?, ?,?)";

        try (Connection conn = DBUtils.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, product.getMobileId());
            ps.setString(2, product.getMobileName());
            ps.setDouble(3, product.getPrice());
            ps.setInt(4, product.getQuantity());
            ps.setString(5, product.getDescription());
            ps.setString(6, product.getMobileBrand());
            ps.setString(7, product.getImage());
            
            int affectedRows = ps.executeUpdate();

            if (affectedRows > 0) {
                isAdded = true;
            }
        }
        return isAdded;
    }

    public boolean update(ProductDTO product) throws SQLException {
        boolean checkUpdate = false;
        String sql = "UPDATE tblMobile SET mobileId=?, mobileName=?,mobileBrand=?, price=?, quantity=?, description=?,sale=? WHERE mobileId=?";
        try (Connection conn = DBUtils.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, product.getMobileId());
            ps.setString(2, product.getMobileName());
            ps.setString(3, product.getMobileBrand());
            ps.setDouble(4, product.getPrice());
            ps.setInt(5, product.getQuantity());
            ps.setString(6, product.getDescription());
            ps.setDouble(7, product.getSale());
            ps.setString(8, product.getMobileId());

            checkUpdate = ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return checkUpdate;
    }

    public List<ProductDTO> getAllProducts() throws Exception {
        List<ProductDTO> list = new ArrayList<>();
        String sql = "SELECT mobileId,mobileBrand, description, mobileName, price, quantity,sale,image FROM tblMobile";

        try (Connection conn = DBUtils.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    String mobileId = rs.getString("mobileId");
                    String mobileName = rs.getString("mobileName");
                    String imgae = rs.getString("image");
                    double price = rs.getDouble("price");
                    int quantity = rs.getInt("quantity");
                    double sale = rs.getDouble("sale");
                    String mobileBrand = rs.getString("mobileBrand");
                    String description = rs.getString("description");
                    list.add(new ProductDTO(mobileId, description, price, mobileName, mobileBrand, quantity, sale, imgae));
                }
            }
        }
        return list;
    }

    public boolean checkDuplicate(String mobileID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {

                ptm = conn.prepareStatement(CHECK_DUPLICATE);
                ptm.setString(1, mobileID);
                rs = ptm.executeQuery();

                if (rs.next()) {
                    check = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return check;
    }

    public boolean insertV2(ProductDTO product) throws ClassNotFoundException, SQLException {
        boolean checkInsert = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(INSERT);
                ptm.setString(1, product.getMobileId());
                ptm.setDouble(2, product.getPrice());
                ptm.setString(3, product.getMobileName());
                ptm.setString(4, product.getMobileBrand());
                ptm.setInt(5, product.getQuantity());
                ptm.setDouble(6, product.getSale());
                ptm.setString(7, product.getDescription());
            }

        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return checkInsert;
    }

    public boolean updateQuantity(String phoneId, int quantity) throws SQLException {
        Connection conn = null;
        PreparedStatement ptm = null;
        boolean result = false;

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(UPDATE_QUANTITY);
                ptm.setInt(1, quantity);
                ptm.setString(2, phoneId);
                result = ptm.executeUpdate() > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return result;

    }

   
}
