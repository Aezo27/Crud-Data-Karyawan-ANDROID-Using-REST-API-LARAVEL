package com.example.rama_crud;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class Model {

    private List<ListKaryawan> ListKaryawan = new ArrayList<ListKaryawan>();
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     *     The ListKaryawan
     */
    public List<ListKaryawan> getListKaryawan() {
        return ListKaryawan;
    }

    /**
     *
     * @param ListKaryawan
     *     The ListKaryawan
     */
    public void setListKaryawan(List<ListKaryawan> ListKaryawan) {
        this.ListKaryawan = ListKaryawan;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
