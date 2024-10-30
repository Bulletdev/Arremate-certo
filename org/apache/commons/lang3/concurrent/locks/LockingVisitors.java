/*     */ package org.apache.commons.lang3.concurrent.locks;
/*     */ 
/*     */ import java.util.Objects;
/*     */ import java.util.concurrent.locks.Lock;
/*     */ import java.util.concurrent.locks.ReadWriteLock;
/*     */ import java.util.concurrent.locks.ReentrantReadWriteLock;
/*     */ import java.util.concurrent.locks.StampedLock;
/*     */ import java.util.function.Supplier;
/*     */ import org.apache.commons.lang3.function.Failable;
/*     */ import org.apache.commons.lang3.function.FailableConsumer;
/*     */ import org.apache.commons.lang3.function.FailableFunction;
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
/*     */ public class LockingVisitors
/*     */ {
/*     */   public static class LockVisitor<O, L>
/*     */   {
/*     */     private final L lock;
/*     */     private final O object;
/*     */     private final Supplier<Lock> readLockSupplier;
/*     */     private final Supplier<Lock> writeLockSupplier;
/*     */     
/*     */     protected LockVisitor(O param1O, L param1L, Supplier<Lock> param1Supplier1, Supplier<Lock> param1Supplier2) {
/* 123 */       this.object = Objects.requireNonNull(param1O, "object");
/* 124 */       this.lock = Objects.requireNonNull(param1L, "lock");
/* 125 */       this.readLockSupplier = Objects.<Supplier<Lock>>requireNonNull(param1Supplier1, "readLockSupplier");
/* 126 */       this.writeLockSupplier = Objects.<Supplier<Lock>>requireNonNull(param1Supplier2, "writeLockSupplier");
/*     */     }
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
/*     */     public void acceptReadLocked(FailableConsumer<O, ?> param1FailableConsumer) {
/* 148 */       lockAcceptUnlock(this.readLockSupplier, param1FailableConsumer);
/*     */     }
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
/*     */     public void acceptWriteLocked(FailableConsumer<O, ?> param1FailableConsumer) {
/* 170 */       lockAcceptUnlock(this.writeLockSupplier, param1FailableConsumer);
/*     */     }
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
/*     */     public <T> T applyReadLocked(FailableFunction<O, T, ?> param1FailableFunction) {
/* 210 */       return lockApplyUnlock(this.readLockSupplier, param1FailableFunction);
/*     */     }
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
/*     */     public <T> T applyWriteLocked(FailableFunction<O, T, ?> param1FailableFunction) {
/* 238 */       return lockApplyUnlock(this.writeLockSupplier, param1FailableFunction);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public L getLock() {
/* 247 */       return this.lock;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public O getObject() {
/* 256 */       return this.object;
/*     */     }
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
/*     */     protected void lockAcceptUnlock(Supplier<Lock> param1Supplier, FailableConsumer<O, ?> param1FailableConsumer) {
/* 271 */       Lock lock = param1Supplier.get();
/* 272 */       lock.lock();
/*     */       try {
/* 274 */         param1FailableConsumer.accept(this.object);
/* 275 */       } catch (Throwable throwable) {
/* 276 */         throw Failable.rethrow(throwable);
/*     */       } finally {
/* 278 */         lock.unlock();
/*     */       } 
/*     */     }
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
/*     */     protected <T> T lockApplyUnlock(Supplier<Lock> param1Supplier, FailableFunction<O, T, ?> param1FailableFunction) {
/* 298 */       Lock lock = param1Supplier.get();
/* 299 */       lock.lock();
/*     */       try {
/* 301 */         return (T)param1FailableFunction.apply(this.object);
/* 302 */       } catch (Throwable throwable) {
/* 303 */         throw Failable.rethrow(throwable);
/*     */       } finally {
/* 305 */         lock.unlock();
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class ReadWriteLockVisitor<O>
/*     */     extends LockVisitor<O, ReadWriteLock>
/*     */   {
/*     */     protected ReadWriteLockVisitor(O param1O, ReadWriteLock param1ReadWriteLock) {
/* 330 */       super(param1O, param1ReadWriteLock, param1ReadWriteLock::readLock, param1ReadWriteLock::writeLock);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class StampedLockVisitor<O>
/*     */     extends LockVisitor<O, StampedLock>
/*     */   {
/*     */     protected StampedLockVisitor(O param1O, StampedLock param1StampedLock) {
/* 353 */       super(param1O, param1StampedLock, param1StampedLock::asReadLock, param1StampedLock::asWriteLock);
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
/*     */   public static <O> ReadWriteLockVisitor<O> reentrantReadWriteLockVisitor(O paramO) {
/* 365 */     return new ReadWriteLockVisitor<>(paramO, new ReentrantReadWriteLock());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <O> StampedLockVisitor<O> stampedLockVisitor(O paramO) {
/* 376 */     return new StampedLockVisitor<>(paramO, new StampedLock());
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\concurrent\locks\LockingVisitors.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */