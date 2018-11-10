import UIKit

var str = "Hello, playground"

let maxDouble: Double = 1000000;

func getMagnitude(_ array: [Double]) -> Double {
    var result: Double = 0
    for number in array {
        result += number * number
    }
    return result.squareRoot()
}

getMagnitude([3, 4])
getMagnitude([3, 5, 7, 8,3 ,5])
getMagnitude([1, 2])
getMagnitude([1, 1])

getMagnitude([0])
getMagnitude([])
