package it.softwareInside.LezioneAcademy21.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.softwareInside.LezioneAcademy21.models.Item;
import repository.ItemRepository;


@Service
public class ItemService {
	
	

	@Autowired
	ItemRepository itemRepository;

	
	public boolean addItem(Item item) {
		
		
		if(item == null)
			return false;
		
		try {
		
			itemRepository.save(item);
			
			return true;
			
		} catch (Exception e) {
			System.err.println(e);
			return false;
		}
		
	}
	
	
	
	public boolean update(Item item) {
		
		return addItem(item);
	}
	
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Item deleteItem(int id) {
		
		try {
			
			Item item = itemRepository.findById(id).get();
			
			itemRepository.deleteById(id);
			
			return item;
			
			
		}catch (Exception e) {
			
			System.out.println(e);
			
			return null;
		}
		
		
	}
	
	
	public Item getItemById(int id) {
		
		try {
			
			return itemRepository.findById(id).get();
			
		}catch (Exception e) {
			return null;
		}
		
	}
	
	
	public Iterable<Item> getAllData() {
		
		
		return itemRepository.findAll();
	}
	
	
	
	public double calcolaValoreTotaleMagazzino() {
		
		double sommaTotale = 0 ;
		
		for(Item item  : itemRepository.findAll() )
			sommaTotale += item.getPrezzo();
		
		
		return sommaTotale;
	}
	
	
	
}