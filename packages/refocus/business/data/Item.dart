library domain.data.item;

import 'package:refocus/business/context/Owner.dart';

class Item {
  String name;
  Owner owner;

  Item(this.name, this.owner);
}
