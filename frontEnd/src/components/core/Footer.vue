<template>
  <v-footer
    id="core-footer"
    absolute
    height="82"
  >
    <div class="footer-items">
      <span
        v-for="link in links"
        :key="link.name"
      >
        <a
          :href="link.Link"
          class="tertiary--text footer-links">{{ link.name }}</a>
      </span>
    </div>
    <v-spacer/>
    <span class="font-weight-light copyright">
      &copy;
      {{ (new Date()).getFullYear() }}
      <a
        href="https://www.creative-tim.com/"
        target="_blank">Vitor santos</a>, App
      <v-icon
        color="tertiary"
        size="17">mdi-heart</v-icon>
      Gratuito para todos
    </span>
  </v-footer>
</template>

<script>
export default {
  data: () => ({
    links: [
      { name: 'Inicio', Link: '/#' },
      { name: 'Desenvolvedor', Link: 'https://www.creative-tim.com' },
      { name: 'Dúvidas', Link: 'https://creative-tim.com/presentation' },
      { name: 'Contato', Link: 'https://blog.creative-tim.com' }
    ]
  })
}
</script>

<style>
#core-footer {
  z-index: 0;
}
</style>
