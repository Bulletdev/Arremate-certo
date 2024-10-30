/*     */ package org.jsoup.nodes;
/*     */ 
/*     */ import java.util.AbstractMap;
/*     */ import java.util.AbstractSet;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import org.jsoup.helper.Validate;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Attributes
/*     */   implements Cloneable, Iterable<Attribute>
/*     */ {
/*     */   protected static final String dataPrefix = "data-";
/*  20 */   private LinkedHashMap<String, Attribute> attributes = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String get(String paramString) {
/*  31 */     Validate.notEmpty(paramString);
/*     */     
/*  33 */     if (this.attributes == null) {
/*  34 */       return "";
/*     */     }
/*  36 */     Attribute attribute = this.attributes.get(paramString.toLowerCase());
/*  37 */     return (attribute != null) ? attribute.getValue() : "";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void put(String paramString1, String paramString2) {
/*  46 */     Attribute attribute = new Attribute(paramString1, paramString2);
/*  47 */     put(attribute);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void put(Attribute paramAttribute) {
/*  55 */     Validate.notNull(paramAttribute);
/*  56 */     if (this.attributes == null)
/*  57 */       this.attributes = new LinkedHashMap<String, Attribute>(2); 
/*  58 */     this.attributes.put(paramAttribute.getKey(), paramAttribute);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void remove(String paramString) {
/*  66 */     Validate.notEmpty(paramString);
/*  67 */     if (this.attributes == null)
/*     */       return; 
/*  69 */     this.attributes.remove(paramString.toLowerCase());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasKey(String paramString) {
/*  78 */     return (this.attributes != null && this.attributes.containsKey(paramString.toLowerCase()));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int size() {
/*  86 */     if (this.attributes == null)
/*  87 */       return 0; 
/*  88 */     return this.attributes.size();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addAll(Attributes paramAttributes) {
/*  96 */     if (paramAttributes.size() == 0)
/*     */       return; 
/*  98 */     if (this.attributes == null)
/*  99 */       this.attributes = new LinkedHashMap<String, Attribute>(paramAttributes.size()); 
/* 100 */     this.attributes.putAll(paramAttributes.attributes);
/*     */   }
/*     */   
/*     */   public Iterator<Attribute> iterator() {
/* 104 */     return asList().iterator();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<Attribute> asList() {
/* 113 */     if (this.attributes == null) {
/* 114 */       return Collections.emptyList();
/*     */     }
/* 116 */     ArrayList<? extends Attribute> arrayList = new ArrayList(this.attributes.size());
/* 117 */     for (Map.Entry<String, Attribute> entry : this.attributes.entrySet()) {
/* 118 */       arrayList.add(entry.getValue());
/*     */     }
/* 120 */     return Collections.unmodifiableList(arrayList);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Map<String, String> dataset() {
/* 129 */     return new Dataset();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String html() {
/* 137 */     StringBuilder stringBuilder = new StringBuilder();
/* 138 */     html(stringBuilder, (new Document("")).outputSettings());
/* 139 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   void html(StringBuilder paramStringBuilder, Document.OutputSettings paramOutputSettings) {
/* 143 */     if (this.attributes == null) {
/*     */       return;
/*     */     }
/* 146 */     for (Map.Entry<String, Attribute> entry : this.attributes.entrySet()) {
/* 147 */       Attribute attribute = (Attribute)entry.getValue();
/* 148 */       paramStringBuilder.append(" ");
/* 149 */       attribute.html(paramStringBuilder, paramOutputSettings);
/*     */     } 
/*     */   }
/*     */   
/*     */   public String toString() {
/* 154 */     return html();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 159 */     if (this == paramObject) return true; 
/* 160 */     if (!(paramObject instanceof Attributes)) return false;
/*     */     
/* 162 */     Attributes attributes = (Attributes)paramObject;
/*     */     
/* 164 */     if ((this.attributes != null) ? !this.attributes.equals(attributes.attributes) : (attributes.attributes != null)) return false;
/*     */     
/* 166 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 171 */     return (this.attributes != null) ? this.attributes.hashCode() : 0;
/*     */   }
/*     */   
/*     */   public Attributes clone() {
/*     */     Attributes attributes;
/* 176 */     if (this.attributes == null) {
/* 177 */       return new Attributes();
/*     */     }
/*     */     
/*     */     try {
/* 181 */       attributes = (Attributes)super.clone();
/* 182 */     } catch (CloneNotSupportedException cloneNotSupportedException) {
/* 183 */       throw new RuntimeException(cloneNotSupportedException);
/*     */     } 
/* 185 */     attributes.attributes = new LinkedHashMap<String, Attribute>(this.attributes.size());
/* 186 */     for (Attribute attribute : this)
/* 187 */       attributes.attributes.put(attribute.getKey(), attribute.clone()); 
/* 188 */     return attributes;
/*     */   }
/*     */   
/*     */   private class Dataset
/*     */     extends AbstractMap<String, String> {
/*     */     private Dataset() {
/* 194 */       if (Attributes.this.attributes == null)
/* 195 */         Attributes.this.attributes = (LinkedHashMap)new LinkedHashMap<Object, Object>(2); 
/*     */     }
/*     */     
/*     */     public Set<Map.Entry<String, String>> entrySet() {
/* 199 */       return new EntrySet();
/*     */     }
/*     */ 
/*     */     
/*     */     public String put(String param1String1, String param1String2) {
/* 204 */       String str1 = Attributes.dataKey(param1String1);
/* 205 */       String str2 = Attributes.this.hasKey(str1) ? ((Attribute)Attributes.this.attributes.get(str1)).getValue() : null;
/* 206 */       Attribute attribute = new Attribute(str1, param1String2);
/* 207 */       Attributes.this.attributes.put(str1, attribute);
/* 208 */       return str2;
/*     */     }
/*     */     
/*     */     private class EntrySet extends AbstractSet<Map.Entry<String, String>> {
/*     */       public Iterator<Map.Entry<String, String>> iterator() {
/* 213 */         return new Attributes.Dataset.DatasetIterator();
/*     */       }
/*     */       private EntrySet() {}
/*     */       public int size() {
/* 217 */         byte b = 0;
/* 218 */         Attributes.Dataset.DatasetIterator datasetIterator = new Attributes.Dataset.DatasetIterator();
/* 219 */         while (datasetIterator.hasNext())
/* 220 */           b++; 
/* 221 */         return b;
/*     */       }
/*     */     }
/*     */     
/*     */     private class DatasetIterator implements Iterator<Map.Entry<String, String>> {
/* 226 */       private Iterator<Attribute> attrIter = Attributes.this.attributes.values().iterator(); private Attribute attr;
/*     */       
/*     */       public boolean hasNext() {
/* 229 */         while (this.attrIter.hasNext()) {
/* 230 */           this.attr = this.attrIter.next();
/* 231 */           if (this.attr.isDataAttribute()) return true; 
/*     */         } 
/* 233 */         return false;
/*     */       }
/*     */       
/*     */       public Map.Entry<String, String> next() {
/* 237 */         return new Attribute(this.attr.getKey().substring("data-".length()), this.attr.getValue());
/*     */       }
/*     */       
/*     */       public void remove() {
/* 241 */         Attributes.this.attributes.remove(this.attr.getKey());
/*     */       }
/*     */       
/*     */       private DatasetIterator() {} } }
/*     */   
/*     */   private static String dataKey(String paramString) {
/* 247 */     return "data-" + paramString;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\jsoup\nodes\Attributes.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */