package net.yummycode.jsfplate.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
 
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;
 
import org.richfaces.component.UIExtendedDataTable;
import net.yummycode.jsfplate.domain.CountryItem;

@ManagedBean(name = "countries")
@SessionScoped
public class CountryListBean implements Serializable {
	
	private static final long serialVersionUID = -8219137735408021546L;
	
	private Collection<Object> selection;
	private List<CountryItem> countryItems;
    private List<CountryItem> selectionItems = new ArrayList<CountryItem>();
    
    public void selectionListener(AjaxBehaviorEvent event) {
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
    		init();
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
    
    public void init() {
    	countryItems = new ArrayList<CountryItem>();
    	countryItems.add(new CountryItem("Australia","Canberra","English, Aboriginal native languages"));
    	countryItems.add(new CountryItem("Bolivia","La Paz","Spanish, Quechua, Aymara, Guaraní"));
    	countryItems.add(new CountryItem("Canada","Ottawa","English, French, Indigenous")); 
    	countryItems.add(new CountryItem("Denmark","Copenhagen","Danish"));
    	countryItems.add(new CountryItem("Ethiopia","Addis Ababa","Amharic"));
    	countryItems.add(new CountryItem("France","Paris","French"));
    	countryItems.add(new CountryItem("Ghana","Accra","English, Akan, Fante, Twi, Ga, Dagbani, Ewe"));
    	countryItems.add(new CountryItem("Hungary","Budapest","Hungarian"));
    	countryItems.add(new CountryItem("Iran","Tehran","Persian"));
    	countryItems.add(new CountryItem("Jordan","Amman","Arabic"));
    	countryItems.add(new CountryItem("Kazakhstan","Astana","Kazakh, Russian"));
    	countryItems.add(new CountryItem("Lesotho","Maseru","Sesotho, English"));
    	countryItems.add(new CountryItem("Madagascar","Antananarivo","Malagasy, French"));
    	countryItems.add(new CountryItem("Nepal","Kathmandu","Nepali, Devanagari"));
    	countryItems.add(new CountryItem("Oman","Muscat","Arabic"));
    	countryItems.add(new CountryItem("Poland","Warsaw","Polish"));
    	countryItems.add(new CountryItem("Qatar","Doha","Arabic"));
    	countryItems.add(new CountryItem("Russia","Moscow","Russian"));
    	countryItems.add(new CountryItem("Switzerland","Bern","German, French, Italian, Romansh"));
    	countryItems.add(new CountryItem("Tonga","Nukuʻalofa","Tongan"));
    	countryItems.add(new CountryItem("United Kingdom","London","English, Welsh, Scottish, Scots Gaelic, Irish, Cornish"));
    	countryItems.add(new CountryItem("Vietnam","Hanoi","Vietnamese"));
    	countryItems.add(new CountryItem("Zimbabwe","Harare","Shona"));
    }
}
