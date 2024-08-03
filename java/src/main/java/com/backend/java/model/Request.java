package com.backend.java.model;

public class Request {

   private int requestId;
   private int requestService;
   private String details;
   private boolean isCompleted;
   private int completedBy;
   private String requestLocation;

//   public Request(int requestId, int requestService, String details, boolean isCompleted, int completedBy, String requestLocation) {
//      this.requestId = requestId;
//      this.requestService = requestService;
//      this.details = details;
//      this.isCompleted = isCompleted;
//      this.completedBy = completedBy;
//      this.requestLocation = requestLocation;
//   }


   public int getRequestId() {
      return requestId;
   }

   public void setRequestId(int requestId) {
      this.requestId = requestId;
   }

   public int getRequestService() {
      return requestService;
   }

   public void setRequestService(int requestService) {
      this.requestService = requestService;
   }

   public String getDetails() {
      return details;
   }

   public void setDetails(String details) {
      this.details = details;
   }

   public boolean isCompleted() {
      return isCompleted;
   }

   public void setCompleted(boolean completed) {
      isCompleted = completed;
   }

   public int getCompletedBy() {
      return completedBy;
   }

   public void setCompletedBy(int completedBy) {
      this.completedBy = completedBy;
   }

   public String getRequestLocation() {
      return requestLocation;
   }

   public void setRequestLocation(String requestLocation) {
      this.requestLocation = requestLocation;
   }

   @Override
   public String toString() {
      return "Request{" +
              "requestId=" + requestId +
              ", requestService=" + requestService +
              ", details='" + details + '\'' +
              ", isCompleted=" + isCompleted +
              ", completedBy=" + completedBy +
              ", requestLocation='" + requestLocation + '\'' +
              '}';
   }
}
