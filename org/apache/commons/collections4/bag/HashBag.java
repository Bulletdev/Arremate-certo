/*    */ package org.apache.commons.collections4.bag;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.io.ObjectInputStream;
/*    */ import java.io.ObjectOutputStream;
/*    */ import java.io.Serializable;
/*    */ import java.util.Collection;
/*    */ import java.util.HashMap;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class HashBag<E>
/*    */   extends AbstractMapBag<E>
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = -6561115435802554013L;
/*    */   
/*    */   public HashBag() {
/* 48 */     super(new HashMap<E, AbstractMapBag.MutableInteger>());
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public HashBag(Collection<? extends E> paramCollection) {
/* 57 */     this();
/* 58 */     addAll(paramCollection);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private void writeObject(ObjectOutputStream paramObjectOutputStream) throws IOException {
/* 66 */     paramObjectOutputStream.defaultWriteObject();
/* 67 */     doWriteObject(paramObjectOutputStream);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private void readObject(ObjectInputStream paramObjectInputStream) throws IOException, ClassNotFoundException {
/* 74 */     paramObjectInputStream.defaultReadObject();
/* 75 */     doReadObject(new HashMap<E, AbstractMapBag.MutableInteger>(), paramObjectInputStream);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\bag\HashBag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */