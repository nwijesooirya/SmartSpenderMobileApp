package com.example.trackly.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.trackly.data.AppDatabase
import com.example.trackly.data.FinanceRepository
import com.example.trackly.model.Budget
import com.example.trackly.model.Category
import com.example.trackly.model.Transaction
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class FinanceViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: FinanceRepository
    val allTransactions: Flow<List<Transaction>>
    val allBudgets: Flow<List<Budget>>
    val allCategories: Flow<List<Category>>

    init {
        val database = AppDatabase.getDatabase(application)
        repository = FinanceRepository(
            database.transactionDao(),
            database.budgetDao(),
            database.categoryDao()
        )
        allTransactions = repository.getAllTransactions()
        allBudgets = repository.getAllBudgets()
        allCategories = repository.getAllCategories()
    }

    // Transaction operations
    fun insertTransaction(transaction: Transaction) = viewModelScope.launch {
        repository.insertTransaction(transaction)
    }

    fun updateTransaction(transaction: Transaction) = viewModelScope.launch {
        repository.updateTransaction(transaction)
    }

    fun deleteTransaction(transaction: Transaction) = viewModelScope.launch {
        repository.deleteTransaction(transaction)
    }

    fun getTransactionsBetweenDates(startDate: Long, endDate: Long): Flow<List<Transaction>> =
        repository.getTransactionsBetweenDates(startDate, endDate)

    fun getTransactionsByCategory(category: String): Flow<List<Transaction>> =
        repository.getTransactionsByCategory(category)

    suspend fun getTotalExpensesBetweenDates(startDate: Long, endDate: Long): Double? =
        repository.getTotalExpensesBetweenDates(startDate, endDate)

    suspend fun getTotalIncomeBetweenDates(startDate: Long, endDate: Long): Double? =
        repository.getTotalIncomeBetweenDates(startDate, endDate)

    // Budget operations
    fun insertBudget(budget: Budget) = viewModelScope.launch {
        repository.insertBudget(budget)
    }

    fun updateBudget(budget: Budget) = viewModelScope.launch {
        repository.updateBudget(budget)
    }

    fun deleteBudget(budget: Budget) = viewModelScope.launch {
        repository.deleteBudget(budget)
    }

    suspend fun getBudgetForMonth(year: Int, month: Int): Budget? =
        repository.getBudgetForMonth(year, month)

    fun getBudgetsForYear(year: Int): Flow<List<Budget>> =
        repository.getBudgetsForYear(year)

    // Category operations
    fun insertCategory(category: Category) = viewModelScope.launch {
        repository.insertCategory(category)
    }

    fun insertCategories(categories: List<Category>) = viewModelScope.launch {
        repository.insertCategories(categories)
    }

    fun updateCategory(category: Category) = viewModelScope.launch {
        repository.updateCategory(category)
    }

    fun deleteCategory(category: Category) = viewModelScope.launch {
        repository.deleteCategory(category)
    }

    fun deleteAllCategories() = viewModelScope.launch {
        repository.deleteAllCategories()
    }
} 