package com.example.sectionedrecylerview;

import java.util.List;

public class Section {

    private String sectionName;
    private List<String> sectionItems;

    private List<String> sectionItem1;
    List<Integer> sectionItemsImage;

    public Section(String sectionName, List<String> sectionItems, List<String> sectionItem1,List<Integer> sectionItemsImage) {
        this.sectionName = sectionName;
        this.sectionItems = sectionItems;
        this.sectionItemsImage = sectionItemsImage;
        this.sectionItem1=sectionItem1;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public List<String> getSectionItems() {
        return sectionItems;
    }

    public void setSectionItems(List<String> sectionItems) {
        this.sectionItems = sectionItems;
    }

    public List<String> getSectionItem1() {
        return sectionItem1;
    }

    public void setSectionItem1(List<String> sectionItem1) {
        this.sectionItem1 = sectionItem1;
    }

    public List<Integer> getSectionItemsImage() {
        return sectionItemsImage;
    }

    public void setSectionItemsImage(List<Integer> sectionItemsImage) {
        this.sectionItemsImage = sectionItemsImage;
    }

    //    @Override
//    public String toString() {
//        return "Section{" +
//                "sectionName='" + sectionName + '\'' +
//                ", sectionItems=" + sectionItems +
//                '}';
//    }
}
