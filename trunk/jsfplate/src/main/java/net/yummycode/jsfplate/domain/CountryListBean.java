package net.yummycode.jsfplate.domain;

/**
 * The Bean handling a list of items (country) for a table
 * 
 * @author Francois Andry
 * @version 1.0
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
 
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;
 
import org.richfaces.component.UIExtendedDataTable;

import net.yummycode.jsfplate.domain.CountryItem;
import net.yummycode.jsfplate.util.Processing;

@ManagedBean(name = "countries")
@SessionScoped
public class CountryListBean implements Serializable {
	
	private static final long serialVersionUID = -8219137735408021546L;
	
	private Collection<Object> selection;
	private List<CountryItem> countryItems;
    private List<CountryItem> selectionItems = new ArrayList<CountryItem>();
    
    public void selectionListener(AjaxBehaviorEvent event) {
    	Processing.waiting(500);
        UIExtendedDataTable dataTable = (UIExtendedDataTable) event.getComponent();
        Object originalKey = dataTable.getRowKey();
        selectionItems.clear();
        for (Object selectionKey : selection) {
            dataTable.setRowKey(selectionKey);
            if (dataTable.isRowAvailable()) {
                selectionItems.add((CountryItem) dataTable.getRowData());
            }
        }
        dataTable.setRowKey(originalKey);
    }
 
    public Collection<Object> getSelection() {
        return selection;
    }
 
    public void setSelection(Collection<Object> selection) {
        this.selection = selection;
    }
 
    public List<CountryItem> getCountryItems() {
    	if (countryItems == null) {
    		retrieveCountryStats();
    	}
        return countryItems;
    }
 
    public void setCountryItems(List<CountryItem> countryItems) {
        this.countryItems = countryItems;
    }
 
    public CountryItem getSelectionItem() {
        if (selectionItems == null || selectionItems.isEmpty()) {
            return null;
        }
        return selectionItems.get(0);
    }
 
    public List<CountryItem> getSelectionItems() {
        return selectionItems;
    }
 
    public void setSelectionItems(List<CountryItem> selectionItems) {
        this.selectionItems = selectionItems;
    }
    
    public void refresh() {
    	Processing.waiting(1000);
    	retrieveCountryStats();
    }
    
    public void retrieveCountryStats() {
    	countryItems = new ArrayList<CountryItem>();
    	countryItems.add(new CountryItem("Australia","Canberra","English, Aboriginal native languages","1515468"));
    	countryItems.add(new CountryItem("Bolivia","La Paz","Spanish, Quechua, Aymara, Guaraní","23949"));
    	countryItems.add(new CountryItem("Canada","Ottawa","English, French, Indigenous","1736869")); 
    	countryItems.add(new CountryItem("Denmark","Copenhagen","Danish","332019"));
    	countryItems.add(new CountryItem("Ethiopia","Addis Ababa","Amharic","30247"));
    	countryItems.add(new CountryItem("France","Paris","French","2775518"));
    	countryItems.add(new CountryItem("Ghana","Accra","English, Akan, Fante, Twi, Ga, Dagbani, Ewe","39200"));
    	countryItems.add(new CountryItem("Hungary","Budapest","Hungarian","138714"));
    	countryItems.add(new CountryItem("Iran","Tehran","Persian","521835"));
    	countryItems.add(new CountryItem("Jordan","Amman","Arabic","28840"));
    	countryItems.add(new CountryItem("Kazakhstan","Astana","Kazakh, Russian","186427"));
    	countryItems.add(new CountryItem("Lesotho","Maseru","Sesotho, English","2443"));
    	countryItems.add(new CountryItem("Madagascar","Antananarivo","Malagasy, French","9844"));
    	countryItems.add(new CountryItem("Nepal","Kathmandu","Nepali, Devanagari","18501"));
    	countryItems.add(new CountryItem("Oman","Muscat","Arabic","72680"));
    	countryItems.add(new CountryItem("Poland","Warsaw","Polish","514115"));
    	countryItems.add(new CountryItem("Qatar","Doha","Arabic","173320"));
    	countryItems.add(new CountryItem("Russia","Moscow","Russian","1857770"));
    	countryItems.add(new CountryItem("Switzerland","Bern","German, French, Italian, Romansh","660762"));
    	countryItems.add(new CountryItem("Tonga","Nukuʻalofa","Tongan","453"));
    	countryItems.add(new CountryItem("United Kingdom","London","English, Welsh, Scottish, Scots Gaelic, Irish, Cornish","2429184"));
    	countryItems.add(new CountryItem("Vietnam","Hanoi","Vietnamese","123600"));
    	countryItems.add(new CountryItem("Zimbabwe","Harare","Shona","8865"));
    }
}
