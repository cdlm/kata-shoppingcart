# Java kata: shopping cart & item pricing policies

This kata models the checkout price calculation of a shop (either an online shop or a physical one, at the cash register).

- **Items** represent goods that can be placed in the cart.

- A **cart** contains a number of items, and can compute the total price of its contents.
There is no notion of inventory or of physical instances of products: a given item represents the general product, not the actual physical instance of that product.
Therefore, to represent the purchase of several instances of a product, the corresponding item object will be added that many times to the cart.

- Cart items can either be actual **products** with a fixed unit price, or products with a **pricing policy** attached.
Pricing policies influence the asked price for the whole cart, like special offers, promotions, etc.


### License

<a rel="license" href="http://creativecommons.org/licenses/by-sa/3.0/deed.en_US"><img alt="Creative Commons License" style="border-width:0" src="http://i.creativecommons.org/l/by-sa/3.0/88x31.png" /></a><br />This work by <a xmlns:cc="http://creativecommons.org/ns#" href="https://github.com/cdlm" property="cc:attributionName" rel="cc:attributionURL">Damien Pollet</a> is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-sa/3.0/deed.en_US">Creative Commons Attribution-ShareAlike 3.0 Unported License</a>.
