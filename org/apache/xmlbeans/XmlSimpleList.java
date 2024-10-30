/*     */ package org.apache.xmlbeans;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.ListIterator;
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
/*     */ public class XmlSimpleList
/*     */   implements Serializable, List
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private List underlying;
/*     */   
/*     */   public XmlSimpleList(List paramList) {
/*  41 */     this.underlying = paramList;
/*     */   }
/*     */   public int size() {
/*  44 */     return this.underlying.size();
/*     */   } public boolean isEmpty() {
/*  46 */     return this.underlying.isEmpty();
/*     */   } public boolean contains(Object paramObject) {
/*  48 */     return this.underlying.contains(paramObject);
/*     */   } public boolean containsAll(Collection paramCollection) {
/*  50 */     return this.underlying.containsAll(paramCollection);
/*     */   } public Object[] toArray() {
/*  52 */     return this.underlying.toArray();
/*     */   } public Object[] toArray(Object[] paramArrayOfObject) {
/*  54 */     return this.underlying.toArray(paramArrayOfObject);
/*     */   }
/*     */   public boolean add(Object paramObject) {
/*  57 */     throw new UnsupportedOperationException();
/*     */   } public boolean addAll(Collection paramCollection) {
/*  59 */     throw new UnsupportedOperationException();
/*     */   } public boolean remove(Object paramObject) {
/*  61 */     throw new UnsupportedOperationException();
/*     */   } public boolean removeAll(Collection paramCollection) {
/*  63 */     throw new UnsupportedOperationException();
/*     */   } public boolean retainAll(Collection paramCollection) {
/*  65 */     throw new UnsupportedOperationException();
/*     */   } public void clear() {
/*  67 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   public Object get(int paramInt) {
/*  70 */     return this.underlying.get(paramInt);
/*     */   } public Object set(int paramInt, Object paramObject) {
/*  72 */     throw new UnsupportedOperationException();
/*     */   } public void add(int paramInt, Object paramObject) {
/*  74 */     throw new UnsupportedOperationException();
/*     */   } public Object remove(int paramInt) {
/*  76 */     throw new UnsupportedOperationException();
/*     */   } public int indexOf(Object paramObject) {
/*  78 */     return this.underlying.indexOf(paramObject);
/*     */   } public int lastIndexOf(Object paramObject) {
/*  80 */     return this.underlying.lastIndexOf(paramObject);
/*     */   } public boolean addAll(int paramInt, Collection paramCollection) {
/*  82 */     throw new UnsupportedOperationException();
/*     */   } public List subList(int paramInt1, int paramInt2) {
/*  84 */     return new XmlSimpleList(this.underlying.subList(paramInt1, paramInt2));
/*     */   }
/*     */ 
/*     */   
/*     */   public Iterator iterator() {
/*  89 */     return new Iterator() {
/*     */         private final XmlSimpleList this$0;
/*  91 */         Iterator i = XmlSimpleList.this.underlying.iterator(); public boolean hasNext() {
/*  92 */           return this.i.hasNext(); }
/*  93 */         public Object next() { return this.i.next(); } public void remove() {
/*  94 */           throw new UnsupportedOperationException();
/*     */         }
/*     */       };
/*     */   }
/*     */   public ListIterator listIterator() {
/*  99 */     return listIterator(0);
/*     */   }
/*     */   
/*     */   public ListIterator listIterator(final int index) {
/* 103 */     return new ListIterator()
/*     */       {
/* 105 */         ListIterator i = XmlSimpleList.this.underlying.listIterator(index); private final int val$index; private final XmlSimpleList this$0;
/*     */         
/* 107 */         public boolean hasNext() { return this.i.hasNext(); }
/* 108 */         public Object next() { return this.i.next(); }
/* 109 */         public boolean hasPrevious() { return this.i.hasPrevious(); }
/* 110 */         public Object previous() { return this.i.previous(); }
/* 111 */         public int nextIndex() { return this.i.nextIndex(); } public int previousIndex() {
/* 112 */           return this.i.previousIndex();
/*     */         }
/* 114 */         public void remove() { throw new UnsupportedOperationException(); }
/* 115 */         public void set(Object param1Object) { throw new UnsupportedOperationException(); } public void add(Object param1Object) {
/* 116 */           throw new UnsupportedOperationException();
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   private String stringValue(Object paramObject) {
/* 122 */     if (paramObject instanceof SimpleValue)
/* 123 */       return ((SimpleValue)paramObject).stringValue(); 
/* 124 */     return paramObject.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 134 */     int i = this.underlying.size();
/* 135 */     if (i == 0)
/* 136 */       return ""; 
/* 137 */     String str = stringValue(this.underlying.get(0));
/* 138 */     if (i == 1)
/* 139 */       return str; 
/* 140 */     StringBuffer stringBuffer = new StringBuffer(str);
/* 141 */     for (byte b = 1; b < i; b++) {
/*     */       
/* 143 */       stringBuffer.append(' ');
/* 144 */       stringBuffer.append(stringValue(this.underlying.get(b)));
/*     */     } 
/* 146 */     return stringBuffer.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 156 */     if (this == paramObject) return true; 
/* 157 */     if (!(paramObject instanceof XmlSimpleList)) return false; 
/* 158 */     XmlSimpleList xmlSimpleList = (XmlSimpleList)paramObject;
/* 159 */     List list = xmlSimpleList.underlying;
/* 160 */     int i = this.underlying.size();
/* 161 */     if (i != list.size())
/* 162 */       return false; 
/* 163 */     for (byte b = 0; b < i; b++) {
/*     */       
/* 165 */       Object object1 = this.underlying.get(b);
/* 166 */       Object object2 = list.get(b);
/* 167 */       if ((object1 == null) ? (object2 != null) : !object1.equals(object2))
/* 168 */         return false; 
/*     */     } 
/* 170 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 178 */     int i = this.underlying.size();
/* 179 */     int j = 0;
/* 180 */     for (byte b = 0; b < i; b++) {
/*     */       
/* 182 */       Object object = this.underlying.get(b);
/* 183 */       j *= 19;
/* 184 */       j += object.hashCode();
/*     */     } 
/* 186 */     return j;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\XmlSimpleList.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */