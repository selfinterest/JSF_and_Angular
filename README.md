JSF and Angular
===============

JSF and Angular can get along... kinda. I use the Jackson library with my backing bean, storing the JSON in a field on the bean itself.

Just don't forget to annotate the `getJson()` method to exempt it from serialization! Otherwise, Jackson gets stuck in a horrible loop.
