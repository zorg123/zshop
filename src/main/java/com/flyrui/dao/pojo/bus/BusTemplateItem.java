package com.flyrui.dao.pojo.bus;

import java.io.Serializable;

public class BusTemplateItem implements Serializable {
    private Integer item_id;

    private String template_id;

    private String item_name;

    private String item_type;

    private String data_col;

    private Integer rule_id;

    private Integer order_id;
    
    private String is_display;
    
    private Integer col_index;
    
    private String is_export;
    
    private String display_width;

    private static final long serialVersionUID = 1L;

    public Integer getItem_id() {
        return item_id;
    }

    public void setItem_id(Integer item_id) {
        this.item_id = item_id;
    }

    public String getTemplate_id() {
        return template_id;
    }

    public void setTemplate_id(String template_id) {
        this.template_id = template_id == null ? null : template_id.trim();
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name == null ? null : item_name.trim();
    }

    public String getItem_type() {
        return item_type;
    }

    public void setItem_type(String item_type) {
        this.item_type = item_type == null ? null : item_type.trim();
    }

    public String getData_col() {
        return data_col;
    }

    public void setData_col(String data_col) {
        this.data_col = data_col == null ? null : data_col.trim();
    }

    public Integer getRule_id() {
        return rule_id;
    }

    public void setRule_id(Integer rule_id) {
        this.rule_id = rule_id;
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

	public String getIs_display() {
		return is_display;
	}

	public void setIs_display(String isDisplay) {
		is_display = isDisplay;
	}

	public Integer getCol_index() {
		return col_index;
	}

	public void setCol_index(Integer colIndex) {
		col_index = colIndex;
	}

	public String getIs_export() {
		return is_export;
	}

	public void setIs_export(String isExport) {
		is_export = isExport;
	}

	public String getDisplay_width() {
		return display_width;
	}

	public void setDisplay_width(String displayWidth) {
		display_width = displayWidth;
	}
    
	
    
}