mod test;

use test::Solution;

fn main() {
    //let words = vec!["This", "is", "an", "example", "of", "text", "justification."];
    // let words = vec!["What","must","be","acknowledgment","shall","be"];
    let words = vec!["Listen","to","many,","speak","to","a","few."];

    let v =  Solution::full_justify(words.iter().map(|x|  x.to_string()).collect(), 6);

    for x in v{
        println!("{}|", x)
    }
}
