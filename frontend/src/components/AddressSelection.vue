<template>
  <div>
    <input
      id="address-input"
      type="text"
      placeholder="Ingresa tu dirección"
      ref="addressInput"
    />
    <div id="map" style="height: 400px;" ref="map"></div>
  </div>
</template>

<script>
export default {

  data() {
    return {
      coordinates: null,
      map: null,
      marker: null,
    };
  },
  mounted() {
    this.initAutocomplete();
    this.initMap(-33.447487, -70.673676);
  },
  methods: {
    initAutocomplete() {
      const autocomplete = new google.maps.places.Autocomplete(this.$refs.addressInput);

      autocomplete.addListener('place_changed', () => {
        const place = autocomplete.getPlace();

        if (!place.geometry) {
          alert(`No details available for input: '${place.name}'`);
          return;
        }

        this.coordinates = {
          lat: place.geometry.location.lat(),
          lng: place.geometry.location.lng(),
        };

        console.log(this.coordinates)
        this.$emit('location_selected', this.coordinates)

        this.initMap(this.coordinates.lat, this.coordinates.lng);
      });
    },
    initMap(lat, lng) {
      if (!this.map) {
        this.map = new google.maps.Map(this.$refs.map, {
          center: { lat, lng },
          zoom: 10,
        });
      } else {
        this.map.setCenter({ lat, lng });
        this.map.setZoom(18)
      }

      if (!this.marker) {
        this.marker = new google.maps.Marker({
          position: { lat, lng },
          map: this.map,
        });
      } else {
        this.marker.setPosition({ lat, lng });
      }
    },
  },
};
</script>

<style scoped>
input[type="text"], select {
  background-color: #f0f9ff;
  color: #000; 
}

input::placeholder, select::placeholder {
  color: #888; 
}

input:hover, select:hover, input:focus, select:focus {
  background-color: #e6f7ff; 
  outline: none;
}
input, select, button {
  padding: 8px 10px; 
  margin-bottom: 10px;
  border-radius: 5px;
  border: 1px solid #cccccc;
  width: 100%;
  box-sizing: border-box;
  font-size: 0.9rem;
}

</style>
