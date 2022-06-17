package ru.itmo.service;



import ru.itmo.model.Product;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(name = "ProductBean")
public class ProductBean implements ProductInterface {

    @PersistenceContext(unitName = "persistenceUnitName")
    private EntityManager entityManager;

    public ProductBean() {

    }

    public boolean addEmployee(Product product) {
        entityManager.persist(product);
        return true;
    }

//    private String getHTML(String urlToRead) throws Exception {
//        StringBuilder result = new StringBuilder();
//        URL url = new URL(urlToRead);
//        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//        conn.setRequestMethod("GET");
//        try (BufferedReader reader = new BufferedReader(
//                new InputStreamReader(conn.getInputStream()))) {
//            for (String line; (line = reader.readLine()) != null; ) {
//                result.append(line);
//            }
//        }
//        return result.toString();
//    }
}
