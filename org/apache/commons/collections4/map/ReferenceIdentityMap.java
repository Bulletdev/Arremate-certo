/*     */ package org.apache.commons.collections4.map;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.io.Serializable;
/*     */ import java.lang.ref.Reference;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ReferenceIdentityMap<K, V>
/*     */   extends AbstractReferenceMap<K, V>
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = -1266190134568365852L;
/*     */   
/*     */   public ReferenceIdentityMap() {
/*  81 */     super(AbstractReferenceMap.ReferenceStrength.HARD, AbstractReferenceMap.ReferenceStrength.SOFT, 16, 0.75F, false);
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
/*     */   public ReferenceIdentityMap(AbstractReferenceMap.ReferenceStrength paramReferenceStrength1, AbstractReferenceMap.ReferenceStrength paramReferenceStrength2) {
/*  99 */     super(paramReferenceStrength1, paramReferenceStrength2, 16, 0.75F, false);
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
/*     */   
/*     */   public ReferenceIdentityMap(AbstractReferenceMap.ReferenceStrength paramReferenceStrength1, AbstractReferenceMap.ReferenceStrength paramReferenceStrength2, boolean paramBoolean) {
/* 119 */     super(paramReferenceStrength1, paramReferenceStrength2, 16, 0.75F, paramBoolean);
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
/*     */   
/*     */   public ReferenceIdentityMap(AbstractReferenceMap.ReferenceStrength paramReferenceStrength1, AbstractReferenceMap.ReferenceStrength paramReferenceStrength2, int paramInt, float paramFloat) {
/* 139 */     super(paramReferenceStrength1, paramReferenceStrength2, paramInt, paramFloat, false);
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
/*     */ 
/*     */ 
/*     */   
/*     */   public ReferenceIdentityMap(AbstractReferenceMap.ReferenceStrength paramReferenceStrength1, AbstractReferenceMap.ReferenceStrength paramReferenceStrength2, int paramInt, float paramFloat, boolean paramBoolean) {
/* 161 */     super(paramReferenceStrength1, paramReferenceStrength2, paramInt, paramFloat, paramBoolean);
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
/*     */   protected int hash(Object paramObject) {
/* 175 */     return System.identityHashCode(paramObject);
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
/*     */   protected int hashEntry(Object paramObject1, Object paramObject2) {
/* 189 */     return System.identityHashCode(paramObject1) ^ System.identityHashCode(paramObject2);
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
/*     */   protected boolean isEqualKey(Object paramObject1, Object paramObject2) {
/* 205 */     paramObject2 = isKeyType(AbstractReferenceMap.ReferenceStrength.HARD) ? paramObject2 : ((Reference)paramObject2).get();
/* 206 */     return (paramObject1 == paramObject2);
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
/*     */   protected boolean isEqualValue(Object paramObject1, Object paramObject2) {
/* 220 */     return (paramObject1 == paramObject2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void writeObject(ObjectOutputStream paramObjectOutputStream) throws IOException {
/* 228 */     paramObjectOutputStream.defaultWriteObject();
/* 229 */     doWriteObject(paramObjectOutputStream);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream paramObjectInputStream) throws IOException, ClassNotFoundException {
/* 236 */     paramObjectInputStream.defaultReadObject();
/* 237 */     doReadObject(paramObjectInputStream);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\map\ReferenceIdentityMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */