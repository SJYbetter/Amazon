pub struct Solution {}


impl Solution {
    pub fn full_justify(words: Vec<String>, max_width: i32) -> Vec<String> {
        let mut start = 0;
        let maxlen = max_width as usize;

        let mut lines: Vec<String> = Vec::new();

        let mut line_width: usize = 0;

        for p in 0..words.len() {
            let new_line_width =  line_width +  words[p].len() + p - start;
            if  new_line_width <= maxlen{
                line_width += words[p].len();
                continue;
            }

            // println!("{}{} - {}{}", words[start], start, words[p], p);
            let mut line = String::with_capacity(maxlen);

            let mut count = p - 1 - start;
            let mut need_pad_len  = maxlen - line_width - count;

            for i in start..p-1{
                line.push_str(&words[i]);
                line.push(' ');
 
                let pad_len = (need_pad_len as f32 / count as f32).ceil() as usize;
                if pad_len > 0{
                    line.push_str(&(" ".repeat(pad_len)));
                    need_pad_len -= pad_len;
                    count -=1;
                }
            }

            line.push_str(&words[p-1]);
            line.push_str(&" ".repeat(maxlen - line.len()));

            // from start to p -1
            // println!("{:?} {}", line, line_width + count);

            //line.push_str(&words[p-1]);
            lines.push(line);

            start = p;
            line_width = words[p].len();
        }

        let mut line = String::with_capacity(maxlen);
        line.push_str(& words[start..words.len()].join(" "));
        line.push_str(& " ".repeat(maxlen - line_width - ( words.len() - 1 - start)));
        lines.push(line);

        // println!("\"{}\"", line);
        lines
    }
}