package com.example.trackly.data

import com.example.trackly.model.Budget
import com.example.trackly.model.Category
import com.example.trackly.model.Transaction
import kotlinx.coroutines.flow.Flow

class FinanceRepository(
    private val transactionDao: TransactionDao,
    private val budgetDao: BudgetDao,
    private val categoryDao: CategoryDao
) {
    // Transaction operations
    fun getAllTransactions(): Flow<List<Transaction>> = transactionDao.getAllTransactions()
    
    suspend fun getTransactionById(id: String): Transaction? = transactionDao.getTransactionById(id)
    
    suspend fun insertTransaction(transaction: Transaction) = transactionDao.insertTransaction(transaction)
    
    suspend fun updateTransaction(transaction: Transaction) = transactionDao.updateTransaction(transaction)
    
    suspend fun deleteTransaction(transaction: Transaction) = transactionDao.deleteTransaction(transaction)
    
    fun getTransactionsBetweenDates(startDate: Long, endDate: Long): Flow<List<Transaction>> =
        transactionDao.getTransactionsBetweenDates(startDate, endDate)
    
    fun getTransactionsByCategory(category: String): Flow<List<Transaction>> =
        transactionDao.getTransactionsByCategory(category)
    
    suspend fun getTotalExpensesBetweenDates(startDate: Long, endDate: Long): Double? =
        transactionDao.getTotalExpensesBetweenDates(startDate, endDate)
    
    suspend fun getTotalIncomeBetweenDates(startDate: Long, endDate: Long): Double? =
        transactionDao.getTotalIncomeBetweenDates(startDate, endDate)

    // Budget operations
    fun getAllBudgets(): Flow<List<Budget>> = budgetDao.getAllBudgets()
    
    suspend fun getBudgetById(id: Int): Budget? = budgetDao.getBudgetById(id)
    
    suspend fun getBudgetForMonth(year: Int, month: Int): Budget? = budgetDao.getBudgetForMonth(year, month)
    
    suspend fun insertBudget(budget: Budget) = budgetDao.insertBudget(budget)
    
    suspend fun updateBudget(budget: Budget) = budgetDao.updateBudget(budget)
    
    suspend fun deleteBudget(budget: Budget) = budgetDao.deleteBudget(budget)
    
    fun getBudgetsForYear(year: Int): Flow<List<Budget>> = budgetDao.getBudgetsForYear(year)

    // Category operations
    fun getAllCategories(): Flow<List<Category>> = categoryDao.getAllCategories()
    
    suspend fun getCategoryByName(name: String): Category? = categoryDao.getCategoryByName(name)
    
    suspend fun insertCategory(category: Category) = categoryDao.insertCategory(category)
    
    suspend fun insertCategories(categories: List<Category>) = categoryDao.insertCategories(categories)
    
    suspend fun updateCategory(category: Category) = categoryDao.updateCategory(category)
    
    suspend fun deleteCategory(category: Category) = categoryDao.deleteCategory(category)
    
    suspend fun deleteAllCategories() = categoryDao.deleteAllCategories()
} 