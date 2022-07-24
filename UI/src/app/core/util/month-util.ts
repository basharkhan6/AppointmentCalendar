export class MonthUtil {
  static numberOfDays(month: number) {
    return new Date(2022, month, 0).getDate();
  }
}
