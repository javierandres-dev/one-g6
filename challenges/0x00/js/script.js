const d = document,
  encodeKeys = {
    e: 'enter',
    i: 'imes',
    a: 'ai',
    o: 'ober',
    u: 'ufat',
  },
  re = /^[a-z \W]+$/;

const $input = d.getElementById('input'),
  $output = d.getElementById('output'),
  $encode = d.getElementById('encode'),
  $decode = d.getElementById('decode'),
  $copy = d.getElementById('copy');

d.addEventListener('DOMContentLoaded', eventsListener);

function eventsListener() {
  $input.addEventListener('change', handleInput);
  $encode.addEventListener('click', () => {
    handleClick('encode');
  });
  $decode.addEventListener('click', () => {
    handleClick('decode');
  });
  $copy.addEventListener('click', handleCopy);
}

function handleInput() {
  if (re.test($input.value)) {
    $encode.removeAttribute('disabled');
    $decode.removeAttribute('disabled');
  } else {
    $encode.setAttribute('disabled', true);
    $decode.setAttribute('disabled', true);
  }
}

function handleClick(target) {
  let content = $input.value;
  for (const key in encodeKeys) {
    const value = encodeKeys[key];
    if (target === 'encode')
      if (content.includes(key)) content = content.replaceAll(key, value);
    if (target === 'decode')
      if (content.includes(value)) content = content.replaceAll(value, key);
  }
  handleOutput(content);
}

function handleOutput(content) {
  $input.value = '';
  $input.placeholder = '';
  $input.setAttribute('disabled', true);
  $encode.setAttribute('disabled', true);
  $decode.setAttribute('disabled', true);
  $output.textContent = content;
  const $outputA = d.querySelector('.output-a'),
    $outputB = d.querySelector('.output-b');
  $outputA.classList.toggle('d-none');
  $outputB.classList.toggle('d-none');
}

function handleCopy() {
  $output.select();
  $output.setSelectionRange(0, 99999);
  navigator.clipboard.writeText($output.value);
  setTimeout(() => {
    location.reload();
  }, 1000);
  alert('¡Copiado!');
}
/* TESTS
gato => gaitober
gaitober => gato
fenterlimescimesdaidenters poberr enternfrenterntair enterstenter dentersaifimesober y haibenterrlober cobernclufatimesdober cobern enterximestober! => felicidades por enfrentar este desafio y haberlo concluido con exito!
*/
