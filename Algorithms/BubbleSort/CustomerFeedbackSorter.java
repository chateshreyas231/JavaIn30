package BubbleSort;

import java.util.Arrays;

public class CustomerFeedbackSorter {

  // Feedback class to store feedback details
  static class Feedback {
    String customerName;
    String feedbackMessage;
    int rating; // Rating out of 10

    Feedback(String customerName, String feedbackMessage, int rating) {
      this.customerName = customerName;
      this.feedbackMessage = feedbackMessage;
      this.rating = rating;
    }

    @Override
    public String toString() {
      return "Feedback{" +
             "customerName='" + customerName + '\'' +
             ", feedbackMessage='" + feedbackMessage + '\'' +
             ", rating=" + rating +
             '}';
    }
  }


  public static void bubbleSortFeedbacks(Feedback[] feedbacks) {
    int lastIndex = feedbacks.length - 1;

    for (int j = 0; j < lastIndex; j++) {
      for (int i = 0; i < lastIndex - j; i++) {
        if (feedbacks[i].rating > feedbacks[i + 1].rating) {
          Feedback tmp = feedbacks[i];
          feedbacks[i] = feedbacks[i + 1];
          feedbacks[i + 1] = tmp;
        }
      }
    }
  }

  public static void main(String[] args) {
    Feedback[] feedbacks = {
      new Feedback("Alice", "Great service!", 9),
      new Feedback("Bob", "Could be better.", 6),
      new Feedback("Charlie", "Excellent support.", 10),
      new Feedback("David", "Not satisfied with the product.", 4),
      new Feedback("Eve", "Amazing experience.", 8)
    };

    System.out.println("Before Sorting:");
    Arrays.stream(feedbacks).forEach(System.out::println);

    bubbleSortFeedbacks(feedbacks);

    System.out.println("\nAfter Sorting:");
    Arrays.stream(feedbacks).forEach(System.out::println);
  }
}
