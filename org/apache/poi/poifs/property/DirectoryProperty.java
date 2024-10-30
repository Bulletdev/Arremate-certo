/*     */ package org.apache.poi.poifs.property;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.Serializable;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Comparator;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DirectoryProperty
/*     */   extends Property
/*     */   implements Iterable<Property>, Parent
/*     */ {
/*     */   private List<Property> _children;
/*     */   private Set<String> _children_names;
/*     */   
/*     */   public DirectoryProperty(String paramString) {
/*  49 */     this._children = new ArrayList<Property>();
/*  50 */     this._children_names = new HashSet<String>();
/*  51 */     setName(paramString);
/*  52 */     setSize(0);
/*  53 */     setPropertyType((byte)1);
/*  54 */     setStartBlock(0);
/*  55 */     setNodeColor((byte)1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected DirectoryProperty(int paramInt1, byte[] paramArrayOfbyte, int paramInt2) {
/*  68 */     super(paramInt1, paramArrayOfbyte, paramInt2);
/*  69 */     this._children = new ArrayList<Property>();
/*  70 */     this._children_names = new HashSet<String>();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean changeName(Property paramProperty, String paramString) {
/*     */     boolean bool;
/*  84 */     String str1 = paramProperty.getName();
/*     */     
/*  86 */     paramProperty.setName(paramString);
/*  87 */     String str2 = paramProperty.getName();
/*     */     
/*  89 */     if (this._children_names.contains(str2)) {
/*     */ 
/*     */ 
/*     */       
/*  93 */       paramProperty.setName(str1);
/*  94 */       bool = false;
/*     */     }
/*     */     else {
/*     */       
/*  98 */       this._children_names.add(str2);
/*  99 */       this._children_names.remove(str1);
/* 100 */       bool = true;
/*     */     } 
/* 102 */     return bool;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean deleteChild(Property paramProperty) {
/* 114 */     boolean bool = this._children.remove(paramProperty);
/*     */     
/* 116 */     if (bool)
/*     */     {
/* 118 */       this._children_names.remove(paramProperty.getName());
/*     */     }
/* 120 */     return bool;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class PropertyComparator
/*     */     implements Serializable, Comparator<Property>
/*     */   {
/*     */     public int compare(Property param1Property1, Property param1Property2) {
/* 142 */       String str1 = "_VBA_PROJECT";
/* 143 */       String str2 = param1Property1.getName();
/* 144 */       String str3 = param1Property2.getName();
/* 145 */       int i = str2.length() - str3.length();
/*     */       
/* 147 */       if (i == 0)
/*     */       {
/*     */         
/* 150 */         if (str2.compareTo(str1) == 0) {
/* 151 */           i = 1;
/* 152 */         } else if (str3.compareTo(str1) == 0) {
/* 153 */           i = -1;
/*     */         
/*     */         }
/* 156 */         else if (str2.startsWith("__") && str3.startsWith("__")) {
/*     */ 
/*     */           
/* 159 */           i = str2.compareToIgnoreCase(str3);
/*     */         }
/* 161 */         else if (str2.startsWith("__")) {
/*     */ 
/*     */           
/* 164 */           i = 1;
/*     */         }
/* 166 */         else if (str3.startsWith("__")) {
/*     */ 
/*     */           
/* 169 */           i = -1;
/*     */         
/*     */         }
/*     */         else {
/*     */           
/* 174 */           i = str2.compareToIgnoreCase(str3);
/*     */         } 
/*     */       }
/* 177 */       return i;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isDirectory() {
/* 186 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void preWrite() {
/* 195 */     if (this._children.size() > 0) {
/*     */       
/* 197 */       Property[] arrayOfProperty = this._children.<Property>toArray(new Property[0]);
/*     */       
/* 199 */       Arrays.sort(arrayOfProperty, new PropertyComparator());
/* 200 */       int i = arrayOfProperty.length / 2;
/*     */       
/* 202 */       setChildProperty(arrayOfProperty[i].getIndex());
/* 203 */       arrayOfProperty[0].setPreviousChild(null);
/* 204 */       arrayOfProperty[0].setNextChild(null); int j;
/* 205 */       for (j = 1; j < i; j++) {
/*     */         
/* 207 */         arrayOfProperty[j].setPreviousChild(arrayOfProperty[j - 1]);
/* 208 */         arrayOfProperty[j].setNextChild(null);
/*     */       } 
/* 210 */       if (i != 0)
/*     */       {
/* 212 */         arrayOfProperty[i].setPreviousChild(arrayOfProperty[i - 1]);
/*     */       }
/*     */       
/* 215 */       if (i != arrayOfProperty.length - 1) {
/*     */         
/* 217 */         arrayOfProperty[i].setNextChild(arrayOfProperty[i + 1]);
/* 218 */         for (j = i + 1; j < arrayOfProperty.length - 1; j++) {
/*     */           
/* 220 */           arrayOfProperty[j].setPreviousChild(null);
/* 221 */           arrayOfProperty[j].setNextChild(arrayOfProperty[j + 1]);
/*     */         } 
/* 223 */         arrayOfProperty[arrayOfProperty.length - 1].setPreviousChild(null);
/* 224 */         arrayOfProperty[arrayOfProperty.length - 1].setNextChild(null);
/*     */       }
/*     */       else {
/*     */         
/* 228 */         arrayOfProperty[i].setNextChild(null);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Iterator<Property> getChildren() {
/* 241 */     return this._children.iterator();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Iterator<Property> iterator() {
/* 248 */     return getChildren();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addChild(Property paramProperty) throws IOException {
/* 262 */     String str = paramProperty.getName();
/*     */     
/* 264 */     if (this._children_names.contains(str))
/*     */     {
/* 266 */       throw new IOException("Duplicate name \"" + str + "\"");
/*     */     }
/* 268 */     this._children_names.add(str);
/* 269 */     this._children.add(paramProperty);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\property\DirectoryProperty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */