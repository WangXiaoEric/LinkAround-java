package guru.springframework.services;


import guru.springframework.commands.ProductForm;
import guru.springframework.converters.ProductFormToProduct;
import guru.springframework.domain.Product;
import guru.springframework.domain.Profile;
import guru.springframework.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

public class UserService {
	
	
    public List<Product> addUser(Profile userInfo) {
		return null;
    }
    
    public List<Profile> getRecommendUser(Profile userInfo) {
		return null;
    }

}
