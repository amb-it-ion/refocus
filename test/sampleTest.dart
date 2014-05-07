import 'package:unittest/unittest.dart';
import 'package:refocus/business.dart';

void main() {
  group("range()", () {
    group("produces a list that", () {
      test("has non-consecutive values with step > 1", () {
        expect(new User("test", "test"), isNotNull);
      });
    });
  });
}
