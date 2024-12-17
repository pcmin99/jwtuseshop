// document.addEventListener('DOMContentLoaded', function() {
//     const chatItems = document.querySelectorAll('.chat-item');
//     const chatWindow = document.querySelector('.chat-window');
//     const chatList = document.querySelector('.tab-content');
//     const backButton = document.querySelector('.chat-back');
    
//     // 채팅 항목 클릭 시
//     chatItems.forEach(item => {
//       item.addEventListener('click', () => {
//         chatList.style.display = 'none';
//         chatWindow.style.display = 'block';
//       });
//     });
    
//     // 뒤로가기 버튼 클릭 시
//     backButton.addEventListener('click', () => {
//       chatWindow.style.display = 'none';
//       chatList.style.display = 'block';
//     });
    
//     // 기존 fixed-plugin 토글 로직과 통합
//     const fixedPlugin = document.querySelector('.fixed-plugin');
//     const fixedPluginButton = document.querySelector('.fixed-plugin-button');
//     const fixedPluginCloseButton = document.querySelector('.fixed-plugin-close-button');
    
//     fixedPluginButton.addEventListener('click', function() {
//       if (!fixedPlugin.classList.contains('show')) {
//         fixedPlugin.classList.add('show');
//       } else {
//         fixedPlugin.classList.remove('show');
//       }
//     });
    
//     fixedPluginCloseButton.addEventListener('click', function() {
//       fixedPlugin.classList.remove('show');
//     });
//   });