const d = document,
  encodeKeys = {
    e: 'enter',
    i: 'imes',
    a: 'ai',
    o: 'ober',
    u: 'ufat',
  },
  re = /^[a-z]+$/;

const $input = d.getElementById('input'),
  $output = d.getElementById('output'),
  $encode = d.getElementById('encode'),
  $decode = d.getElementById('decode'),
  $copy = d.getElementById('copy');

d.addEventListener('DOMContentLoaded', eventsListener);

function eventsListener() {
  $input.addEventListener('change', handleInput);
  $output.addEventListener('change', handleOutput);
  $encode.addEventListener('click', handleEncode);
  $decode.addEventListener('click', handleDecode);
  $copy.addEventListener('click', handleCopy);
}

function handleInput() {
  console.log($input.value);
  console.log(re.test($input.value));
}

function handleOutput() {
  console.log('handle output');
}

function handleEncode() {
  console.log('handle encode');
}

function handleDecode() {
  console.log('handle decode');
}

function handleCopy() {
  console.log('handle copy');
}

/* EXAMPLE
gato => gaitober
gaitober" => gato

fenterlimescimesdaidenters poberr enternfrenterntair enterstenter dentersaifimesober y haibenterrlober cobernclufatimesdober cobern enterximestober!
*/
