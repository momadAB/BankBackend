package com.springboot.bankbackend.service;

import com.springboot.bankbackend.bo.*;
import com.springboot.bankbackend.entity.*;
import java.util.List;

public interface UserService {
  UserResponse createUser(CreateUserRequest request);

  UserResponse updateProfile(UpdateProfileRequest request);

  UserResponse getProfile();

  //  SavingsEntity addFavouriteIcon(FavoriteSavingRequest request);

  // Transaction
  TransactionEntity addTransaction(TransactionRequest request);

  List<TransactionEntity> getTransactions();

  //  TransactionEntity deleteTransaction(Long id);

  UserEntity getUserProfile();

  // Beneficiary
  List<BeneficiaryEntity> getBeneficiaries();

  BeneficiaryEntity addBeneficiary(BeneficiaryRequest request);

  BeneficiaryEntity deleteBeneficiary(Long id);

  List<BeneficiaryEntity> getBeneficiary();

  // Savings
  SavingsEntity addSaving(SavingRequest request);

  List<SavingsEntity> getSaving();

  SavingsEntity updateSaving(Long id, Double amountToAdd);

  SavingsEntity deleteSaving(Long id);

  SavingsEntity addFavouriteSaving(Long savingId);

  // Fixed payment
  FixedPaymentEntity addFixedPayment(FixedPaymentRequest request, Long benficiaryId);

  List<FixedPaymentEntity> getFixedPayment(Long beneficiaryId);

  FixedPaymentEntity deleteFixedPayment(Long paymentId);
}
