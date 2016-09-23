var s = require('../../dist/clojurespec.js');

var even = function (x) { return x%2 === 0; },
  odd = function (x) { return x%2 === 1; },
  four = function (x) { return x === 4; },
  three = function (x) { return x === 3; };

describe('basic examples', function () {
  it('and, or, etc..', function () {
    expect(s.conform(even, 4)).to.equal(4);
    expect(s.conform(even, 0)).to.equal(0);
    expect(s.conform(even, 3)).to.equal(s.invalid);

    expect(s.conform(odd, 1)).to.equal(1);
    expect(s.conform(odd, 3)).to.equal(3);
    expect(s.conform(odd, 4)).to.equal(s.invalid);

    var evenAndFour = s.and(even, four);
    expect(s.conform(evenAndFour, 4)).to.equal(4);
    expect(s.conform(evenAndFour, 0)).to.equal(s.invalid);
    expect(s.conform(evenAndFour, 3)).to.equal(s.invalid);

    var oddOrFour = s.or('a', odd, 'b', four);
    expect(s.conform(oddOrFour, 4)).to.deep.equal(['b', 4]);
    expect(s.conform(oddOrFour, 0)).to.deep.equal(s.invalid);
    expect(s.conform(oddOrFour, 3)).to.deep.equal(['a', 3]);
  });
});
