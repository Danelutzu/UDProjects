package DAO;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import Connection.ConnectionFactory;
import Model.Client;
import Model.Orders;
import Model.Product;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class AbstractDAO<T> {
    protected static final Logger LOGGER = Logger.getLogger(AbstractDAO.class.getName());

    private final Class<T> type;

    @SuppressWarnings("unchecked")
    public AbstractDAO() {
        this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    }
    /**
     * Creaza interogarea de tip SELECT pentru un tabel
     * @param field campurile care se doresc a fi selectate
     * @return Este un obiect al clasei string care contine interogarea
     */
    private String createSelectQuery(String field) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append(" * ");
        sb.append(" FROM ");
        sb.append(type.getSimpleName());
        sb.append(" WHERE " + field + " = ?");
        //System.out.println(sb.toString());
        return sb.toString();
    }
    /**
     * Creaza interogarea de tip INSERT pentru un tabel
     * @return Un obiect al clasei string care contine interogarea
     */
    private String createInsertQuery() {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT ");
        sb.append("INTO ");
        sb.append(type.getSimpleName());
        sb.append(" VALUES (");
        for (Field f : type.getDeclaredFields()) {
            sb.append("?,");
        }
        sb.setLength(sb.length() - 1);
        sb.append(")");
        return sb.toString();
    }

    /**
     * Creaza interogarea de tip UPDATE pentru un tabel
     * @param field campurile care se doresc a fi actualizate
     * @return Un obiect al clasei string care contine interogarea
     */
    private String createUpdateQuery(String field) {
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE ");
        sb.append(type.getSimpleName());
        sb.append(" SET ");
        for (Field f : type.getDeclaredFields()) {
            sb.append(f.getName() + "=? , ");
        }
        sb.setLength(sb.length() - 2); // ca sa renunt la ultima virgula
        sb.append("WHERE " + field + "=?");
        return sb.toString();
    }
    /**
     * Creaza interogarea de tip DELETE pentru un tabel
     * @param field campurile care se doresc a fi sterse
     * @return Un obiect al clasei string care contine interogarea
     */
    private String createDeleteQuery(String field) {
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM ");
        sb.append(type.getSimpleName());
        sb.append(" WHERE " + field + " =?");
        //System.out.println(sb.toString());
        return sb.toString();
    }
    /**
     * Creaza interogarea de tip SELECT *
     * @return Un obiect al clasei string care contine interogarea
     */
    private String createSelectAllQuery() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append(" * ");
        sb.append(" FROM ");
        sb.append(type.getSimpleName());
        // System.out.println(sb.toString());
        return sb.toString();
    }
    /**
     * Insereaza obiectul t in tabelul corespunzator
     * @param t obiectul care trebuie inserat
     * @return Obiectul de tipul T
     */
    public T insert(T t) {
        Connection connection = null;
        PreparedStatement statement = null;
        int resultSet = 0;
        String query = createInsertQuery();
        try {
            int index = 1;
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            for (Field f : type.getDeclaredFields()) {
                PropertyDescriptor propertyDescriptor = new PropertyDescriptor(f.getName(), type);
                Method method = propertyDescriptor.getReadMethod();
                Object s = method.invoke(t);
                statement.setObject(index, s);
                index++;
            }
            resultSet = statement.executeUpdate();
            return t;
        } catch (SQLException | IntrospectionException | IllegalAccessException | IllegalArgumentException
                | InvocationTargetException e) {
            LOGGER.log(Level.WARNING, "DAO:insert " + e.getClass() + e.getMessage());
        } finally {
             //ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }
    /**
     * Gaseste obiectul de tipul T din tabelul corespunzator
     * @param id dupa el se face cautarea
     * @return Obiect de tipul T
     */
    public T findById(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createSelectQuery("id");
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            return createObjects(resultSet).get(0);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }
    /**
     * Actualizeaza obiectul t in tabelul corespunzator
     * @param t obiectul care trebuie actualizat
     * @return Obiectul de tipul T
     */
    public T update(T t) {
        Connection connection = null;
        PreparedStatement statement = null;
        int resultSet = 0;
        String query = createUpdateQuery("id");
        try {
            int index = 1;
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            for (Field f : type.getDeclaredFields()) {
                PropertyDescriptor propertyDescriptor = new PropertyDescriptor(f.getName(), type);
                Method method = propertyDescriptor.getReadMethod();
                Object s = method.invoke(t);
                statement.setObject(index, s);
                index++;
            }
            for (Field f : type.getDeclaredFields()) {
                PropertyDescriptor propertyDescriptor = new PropertyDescriptor(f.getName(), type);
                Method method = propertyDescriptor.getReadMethod();
                Object s = method.invoke(t);
                statement.setObject(index, s);
                break;
            }
            resultSet = statement.executeUpdate();
            return t;
        } catch (SQLException | IntrospectionException | IllegalAccessException | IllegalArgumentException
                | InvocationTargetException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:update " + e.getMessage());
        } finally {
            // ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }
    /**
     * Sterge obiectul t in tabelul corespunzator
     * @param id respectivului obiect care trebuie sters
     */
    public void delete(int id) {

        Connection connection = null;
        PreparedStatement statement = null;
        String query = createDeleteQuery("id");

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:delete " + e.getMessage());
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
    }
    /**
     * Creaza un array list de obiecte din clasa T care reprezinta toate datele din tabelul corespunzator
     * @return Lista de obiecte de tipul T
     */
    public List<T> findAll() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        ResultSet r = null;
        String query = createSelectAllQuery();
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            return createObjects(resultSet);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO : findall " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }
    /**
     * Creaza obiecte de tipul T cu ajutorul unui result set
     *
     * @param resultSet contine informatii extrase din tabelul corespunzator
     * @return Lista de obiecte de tipul T, fiecare reprezentand o linie din tabel, care se afla in data base
     */
    private List<T> createObjects(ResultSet resultSet) {
        List<T> list = new ArrayList<T>();
        try {
            while (resultSet.next()) {
                T instance = type.newInstance();
                for (Field field : type.getDeclaredFields()) {
                    Object value = resultSet.getObject(field.getName());
                    PropertyDescriptor propertyDescriptor = new PropertyDescriptor(field.getName(), type);
                    Method method = propertyDescriptor.getWriteMethod();
                    method.invoke(instance, value);
                }
                list.add(instance);
            }
        } catch (IllegalAccessException | SQLException | InstantiationException | IntrospectionException
                | InvocationTargetException | IllegalArgumentException | SecurityException e) {
            LOGGER.log(Level.WARNING, type.getName() + "AICI E PROBLEMA " + e.getMessage());
            e.printStackTrace();
        }
        return list;
    }
    /**
     * Selecteaza numele coloanelor si creeaza un table
     *
     * @param obj contine lista cu obiectele dintr-un tabel
     * @return Tabelul cu toate randurile din baza de date
     */
    public JTable createTable(List<T> obj)throws IllegalArgumentException,IllegalAccessException{
        ArrayList<String> columnNamesArrayList = new ArrayList<String>();
        for(Field field : obj.get(0).getClass().getDeclaredFields()) {
            field.setAccessible(true);
            columnNamesArrayList.add(field.getName());
        }
        String[] columnNames = new String[columnNamesArrayList.size()];
        columnNames = columnNamesArrayList.toArray(columnNames);
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        Iterator<T> i = obj.iterator();
        while(i.hasNext()) {
            T object = i.next();
            ArrayList<Object> columnDataAsArrayList = new ArrayList<Object>();
            for(Field field : object.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                columnDataAsArrayList.add(field.get(object));
            }
            Object[] columnDataAsArray = new Object[columnDataAsArrayList.size()];
            columnDataAsArray = columnDataAsArrayList.toArray(columnDataAsArray);
            tableModel.addRow(columnDataAsArray);
        }
        return new JTable(tableModel);
    }
    public <T> List<T> getTable(Class<T> type) {
        List<T> result = new ArrayList<>();
        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM tema3." + type.getSimpleName());
            while (resultSet.next()) {
                T instance = type.getDeclaredConstructor().newInstance();
                for (Field field : instance.getClass().getDeclaredFields()) {
                    field.setAccessible(true);
                    Object value = resultSet.getObject(field.getName());
                    field.set(instance, value);
                }
                result.add(instance);
            }
        } catch (Throwable t) {
            t.printStackTrace();
        }
        return result;
    }
    /**
     * Creaza un array list de obiecte din clasa client care reprezinta toate datele din tabelul corespunzator
     * @return Lista de obiecte de tipul client
     */
    public ArrayList<Client> clientList(){
        ArrayList<Client> clientList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createSelectAllQuery();
        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            Client client;
            while(resultSet.next()){
                client = new Client(resultSet.getInt("ID"),resultSet.getString("NAME"),resultSet.getString("EMAIL"),resultSet.getInt("AGE"));
                clientList.add(client);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
            ConnectionFactory.close(resultSet);
        }
        return clientList;
    }
    /**
     * Creaza un array list de obiecte din clasa product care reprezinta toate datele din tabelul corespunzator
     * @return Lista de obiecte de tipul product
     */
    public ArrayList<Product> productList(){
        ArrayList<Product> productList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createSelectAllQuery();
        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            Product product;
            while(resultSet.next()){
                product = new Product(resultSet.getInt("ID"),resultSet.getString("NAME"),resultSet.getInt("PRICE"),resultSet.getInt("QUANTITY"));
                productList.add(product);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
            ConnectionFactory.close(resultSet);
        }
        return productList;
    }

    /**
     * Creaza un array list de obiecte din clasa orders care reprezinta toate datele din tabelul corespunzator
     * @return Lista de obiecte de tipul orders
     */
    public ArrayList<Orders> ordersList(){
        ArrayList<Orders> ordersList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createSelectAllQuery();
        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            Orders orders;
            while(resultSet.next()){
                orders = new Orders(resultSet.getInt("ID"),resultSet.getInt("IDCLIENT"),resultSet.getInt("IDPRODUCT"),resultSet.getInt("QUANTITY"), resultSet.getInt("PRICE"));
                ordersList.add(orders);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
            ConnectionFactory.close(resultSet);
        }
        return ordersList;
    }
}
