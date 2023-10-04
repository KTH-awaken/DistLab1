package com.example.distlab1.DB.DAO.Implementation;

import com.example.distlab1.BO.Entities.ActionResult;
import com.example.distlab1.BO.Entities.Product;
import com.example.distlab1.DB.DAO.ICartDAO;
import com.example.distlab1.DB.Database.DatabaseException;


public class CartDAO implements ICartDAO {
    @Override
    public ActionResult<Product> addToCart(int userId, int productId) throws DatabaseException {
//        ActionResult<Product> actionResult = new ActionResult<>();
//
//        try {
//            Connection conn = DatabaseConnection.getInstance().getConnection();
//            String sql = "insert into t_cart_product (user_id, ) t_users";
//            PreparedStatement preparedStatement = conn.prepareStatement(sql);
//
//
//        }catch (SQLException e){
//            throw new DatabaseException(e.getMessage(), e);
//        }
        return null;
    }

    @Override
    public ActionResult<Product> removeFromCart(int userId, int productId) throws DatabaseException {
        return null;
    }
}
